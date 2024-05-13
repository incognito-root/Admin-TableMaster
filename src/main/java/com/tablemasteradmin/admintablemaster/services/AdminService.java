package com.tablemasteradmin.admintablemaster.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tablemasteradmin.admintablemaster.model.Admin;

import java.io.IOException;

public class AdminService extends MainService {
    public boolean adminLogin(Admin admin) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        String reqBody = mapper.writeValueAsString(admin);

        int result = postRequest("admin/loginAdmin", reqBody).statusCode();

        return result == 200; // OK
    }
}
