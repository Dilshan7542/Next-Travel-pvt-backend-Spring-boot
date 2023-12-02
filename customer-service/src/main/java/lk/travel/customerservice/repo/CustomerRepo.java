package lk.travel.customerservice.repo;

import lk.travel.customerservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    Customer findByEmail(String email);
    @Modifying
    @Query(value = "UPDATE Customer SET nic=?1, name=?2,address=?3,tel=?4 WHERE customerID=?5")
    int updateCustomer(String nic,String name,String address,String tel,int customerID);
}
