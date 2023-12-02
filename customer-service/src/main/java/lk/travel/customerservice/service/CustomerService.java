package lk.travel.customerservice.service;

import lk.travel.customerservice.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    CustomerDTO updateCustomer(CustomerDTO customerDTO);
    CustomerDTO searchCustomer(int customerID);
    CustomerDTO searchByEmailCustomer(String email);
    void deleteCustomer(int customerID);
    List<CustomerDTO> getAllCustomer();
}
