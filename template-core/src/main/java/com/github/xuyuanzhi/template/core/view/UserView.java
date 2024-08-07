package com.github.xuyuanzhi.template.core.view;

import java.util.Date;

import lombok.Data;

@Data
public class UserView {

	private String id;
	
    private String name;
    
    private String phoneNo;
    
    private String email;
    
    private String password;
    
    private String secureKey;
    
    private String vcode;
    
    private Date vcodeTime;
    
    private String userType;
    
}
