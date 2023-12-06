package lk.travel.authservice.service.impl;

import lk.travel.authservice.dto.UserDTO;
import lk.travel.authservice.entity.Users;
import lk.travel.authservice.repo.UserRepo;
import lk.travel.authservice.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    ModelMapper mapper;
    @Override
    public UserDTO saveUser(UserDTO userDTO) {

        List<Users> list = userRepo.findAllByOrderByUserIDDesc(PageRequest.of(0, 1));
        int nextID=0;
        if(!list.isEmpty()){
            nextID=list.get(0).getUserID();
        }
        if(userRepo.existsById(userDTO.getUserID())){
            throw new RuntimeException("User Already Exists ...!!");
        }
        userDTO.setUserID(++nextID);
            userRepo.save(mapper.map(userDTO, Users.class));
        return userDTO;
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        if(!userRepo.existsById(userDTO.getUserID())){
            throw new RuntimeException("User Not Exists ...!!");
        }
        userRepo.save(mapper.map(userDTO, Users.class));
        return userDTO;
    }

    @Override
    public UserDTO searchUser(int userID) {
        if(!userRepo.existsById(userID)){
            throw new RuntimeException("User Not Exists ...!!");
        }
       return mapper.map(userRepo.findById(userID), UserDTO.class);
    }

    @Override
    public UserDTO searchByEmailUser(String  email) {
        return mapper.map(userRepo.findByEmail(email), UserDTO.class);
    }

    @Override
    public void deleteUser(int userID) {
        if(!userRepo.existsById(userID)){
            throw new RuntimeException("User Not Exists ...!!");
        }
        userRepo.deleteById(userID);
    }

    @Override
    public List<UserDTO> getAllUser() {
       List<UserDTO> map=  mapper.map(userRepo.findAll(),new TypeToken<List<UserDTO>>(){}.getType());
        for (UserDTO userDTO : map) {
            userDTO.setPwd(null);
        }
       return map;
    }
}
