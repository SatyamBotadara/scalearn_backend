package com.scalearn.service;

import com.scalearn.dto.UserDto;
import com.scalearn.entity.ScalearnUser;
import com.scalearn.exception.custom.EmailIdAlreadyPresent;
import org.springframework.stereotype.Service;

@Service
public interface ScalearnUserService {
    UserDto insertUserRecord(ScalearnUser scalearnUser) throws EmailIdAlreadyPresent;
}
