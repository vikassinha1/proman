package com.upgrad.proman.api.controller;

import com.upgrad.proman.api.model.SignupUserResponse;
import com.upgrad.proman.api.model.UserDetailsResponse;
import com.upgrad.proman.service.business.UserBusinessService;
import com.upgrad.proman.service.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserAdminController {

    @Autowired
    private UserBusinessService businessService;

    @RequestMapping(method= RequestMethod.POST, path="/uuid", consumes= MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UserDetailsResponse> getUser(final String userUuid) {
        final UserEntity userEntity = businessService.getUser(userUuid);

        UserDetailsResponse userDetailsResponse = new UserDetailsResponse().id(userEntity.getUuid()).emailAddress(userEntity.getEmail()).firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName()).mobileNumber(userEntity.getMobilePhone());
        return new ResponseEntity<UserDetailsResponse>(userDetailsResponse,HttpStatus.CREATED);
    }
}
