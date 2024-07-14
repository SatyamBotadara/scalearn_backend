package com.scalearn.controllers;

import com.scalearn.dto.Response;
import com.scalearn.entity.ScalearnUser;
import com.scalearn.service.ScalearnUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/")
public class UserController {

    private final ScalearnUserService scalearnUserService;

    @PostMapping("register")
    public ResponseEntity<Response> insertNewUser(@RequestBody ScalearnUser scalearnUser) throws Exception {
        var user = scalearnUserService.insertUserRecord(scalearnUser);
        return ResponseEntity.ok(new Response("success",user, HttpStatus.OK));
    }
}
