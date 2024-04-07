package com.example.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.CustomerDetails;

public interface Customerdatadao extends JpaRepository<CustomerDetails, String> {

}
