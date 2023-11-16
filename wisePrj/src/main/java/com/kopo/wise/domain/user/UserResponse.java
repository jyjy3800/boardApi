package com.kopo.wise.domain.user;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class UserResponse {

    private Long id;                      
    private String loginId;               
    private String password;              
    private String name;                  
    private LocalDate birthday;           
    private Boolean deleteYn;             
    private LocalDateTime createdDate;    
    private LocalDateTime modifiedDate;   
    private int role;					  
    
    public void clearPassword() {
        this.password = "";
    }

}
