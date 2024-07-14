package com.scalearn.service.impl;

import com.scalearn.dto.UserDto;
import com.scalearn.entity.ScalearnUser;
import com.scalearn.exception.custom.EmailIdAlreadyPresent;
import com.scalearn.repository.ScalearnUserRepo;
import com.scalearn.service.ScalearnUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ScalearnUserServiceImpl implements ScalearnUserService {

    private final ScalearnUserRepo scalearnUserRepo;

    @Override
    public UserDto insertUserRecord(ScalearnUser scalearnUser) throws EmailIdAlreadyPresent {
        final var id = UUID.randomUUID().toString();
        scalearnUser.setId(id);
        //TODO: configure global exception handler
        var scalearnUserOptional = scalearnUserRepo.findByEmailId(scalearnUser.getEmailId());
        if( scalearnUserOptional.isPresent() ) {
            throw new EmailIdAlreadyPresent( scalearnUserOptional.get().getEmailId() +
                    " Email id is Already Present, Please try to Login!");
        }
        // TODO: store encrypted password spring security
        var user = scalearnUserRepo.save(scalearnUser);
        return new UserDto(user.getId(),user.getUserName(),user.getEmailId());
    }
}