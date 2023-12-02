package lk.travel.customerservice.service.impl;

import lk.travel.customerservice.dto.CustomerDTO;
import lk.travel.customerservice.entity.Customer;
import lk.travel.customerservice.repo.CustomerRepo;
import lk.travel.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepo customerRepo;
    private final ModelMapper mapper;
    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        if(customerRepo.existsById(customerDTO.getCustomerID())){
            throw new RuntimeException("Customer Already Exists..!!");
        }
        customerRepo.save(mapper.map(customerDTO, Customer.class));
        return customerDTO;
    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        if(!customerRepo.existsById(customerDTO.getCustomerID())){
            throw new RuntimeException("Customer Not Exists..!!");
        }
        customerRepo.updateCustomer(customerDTO.getNic(),customerDTO.getName(),customerDTO.getAddress(),customerDTO.getTel(),customerDTO.getCustomerID());

        return searchCustomerUpdate(customerDTO.getCustomerID());
    }

    @Override
    public CustomerDTO searchCustomer(int customerID) {
        if(!customerRepo.existsById(customerID)){
            throw new RuntimeException("Customer Not Exists..!!");
        }
        return mapper.map(customerRepo.findById(customerID),CustomerDTO.class);
    }
    private CustomerDTO searchCustomerUpdate(int customerID) {
        return mapper.map(customerRepo.findById(customerID),CustomerDTO.class);
    }
    @Override
    public CustomerDTO searchByEmailCustomer(String email) {
        return mapper.map(customerRepo.findByEmail(email),CustomerDTO.class);
    }

    @Override
    public void deleteCustomer(int customerID) {
        if(!customerRepo.existsById(customerID)){
            throw new RuntimeException("Customer Not Exists..!!");
        }
        customerRepo.deleteById(customerID);
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        return mapper.map(customerRepo.findAll(),new TypeToken<List<CustomerDTO>>(){}.getType());
    }
}
