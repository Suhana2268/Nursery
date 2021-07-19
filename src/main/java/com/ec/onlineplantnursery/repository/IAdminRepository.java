package com.ec.onlineplantnursery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ec.onlineplantnursery.entity.Admin;
import com.ec.onlineplantnursery.entity.Customer;

public interface IAdminRepository extends JpaRepository<Admin, Integer> {

}
