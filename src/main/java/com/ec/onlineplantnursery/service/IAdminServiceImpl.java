package com.ec.onlineplantnursery.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ec.onlineplantnursery.entity.Admin;
import com.ec.onlineplantnursery.exceptions.AdminIdNotFoundException;
import com.ec.onlineplantnursery.repository.IAdminRepository;



@Service
public class IAdminServiceImpl implements IAdminService{

    @Autowired
    IAdminRepository repository;


    Logger log = LoggerFactory.getLogger(IAdminServiceImpl.class);



    public IAdminServiceImpl(IAdminRepository repository) {
        super();
        this.repository = repository;
    }

    @Override
    @Transactional
    public Admin addAdmin(Admin admin) {
        try {
        	admin.setUserType("2");
            repository.save(admin);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return admin;
    }

    @Override
    @Transactional
    public Admin updateAdmin(Admin admin) throws AdminIdNotFoundException {
        Optional<Admin> optional=repository.findById(admin.getUserId());
        if(optional.isPresent())
        {
            repository.save(admin);
        }
        else {
            throw new AdminIdNotFoundException("Admin Id not found for updation");
        }
        return optional.get();
    }


    @Override
    @Transactional
    public Admin deleteAdmin(int adminId) throws AdminIdNotFoundException {

        Optional<Admin> optional = repository.findById(adminId);
        if (optional.isPresent()) {
            repository.deleteById(adminId);
        } else {
            throw new AdminIdNotFoundException("Admin Id not found for deletion");
        }
        return optional.get();
    }
}


