package com.example.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.CustomerOrders;

public interface Customerorderdao extends JpaRepository<CustomerOrders, String> {

}
