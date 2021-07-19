package com.ec.onlineplantnursery.web;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.zip.Deflater;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ec.onlineplantnursery.exceptions.AdminIdNotFoundException;
import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;
import com.ec.onlineplantnursery.exceptions.SeedIdNotFoundException;
import com.ec.onlineplantnursery.requestDto.AdminRequestDto;
import com.ec.onlineplantnursery.requestDto.SeedRequestDto;
import com.ec.onlineplantnursery.responseDto.AdminResponseDto;
import com.ec.onlineplantnursery.responseDto.SeedResponseDto;
import com.ec.onlineplantnursery.entity.Admin;
import com.ec.onlineplantnursery.entity.Seed;
import com.ec.onlineplantnursery.entity.User;
import com.ec.onlineplantnursery.service.IAdminService;
import com.ec.onlineplantnursery.service.ISeedServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Validated
@RestController
@RequestMapping("/onlinenursery/admin")
@Api(value = "Online Nursery Application")
@CrossOrigin(origins = {"http://localhost:9093", "http://localhost:4200"}, allowedHeaders="*")
public class AdminRestController {
	@Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    IAdminService service;
    
    
    @ApiOperation(value = "add a new Admin", response = Admin.class)
    @PostMapping("/add")
    public ResponseEntity<AdminResponseDto> addUser(@RequestBody @Valid AdminRequestDto admin) {
        
        Admin actual = modelMapper.map(admin, Admin.class);
        AdminResponseDto response = modelMapper.map(this.service.addAdmin(actual), AdminResponseDto.class);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "update profile", response = Admin.class)
    @PutMapping("/update")
    public ResponseEntity<AdminResponseDto> updateUser(@RequestBody @Valid AdminRequestDto admin) throws AdminIdNotFoundException {
        
        Admin actual = modelMapper.map(admin, Admin.class);
        AdminResponseDto response = modelMapper.map(this.service.updateAdmin(actual), AdminResponseDto.class);
        if (response != null) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
    
    @ApiOperation(value = "delete admin", response = User.class)
    @DeleteMapping("/delete/{adminId}")
    public ResponseEntity<AdminResponseDto> removeUser(@PathVariable("adminId") int adminId) throws AdminIdNotFoundException{
        
        AdminResponseDto response = modelMapper.map(this.service.deleteAdmin(adminId), AdminResponseDto.class);
        if (response != null) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }


}
