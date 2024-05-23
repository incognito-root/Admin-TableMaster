package com.tablemasteradmin.admintablemaster.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.tablemasteradmin.admintablemaster.HelperFunction.Popup;
import com.tablemasteradmin.admintablemaster.HelperFunction.PopupTypeEnum;
import com.tablemasteradmin.admintablemaster.model.Admin;
import com.tablemasteradmin.admintablemaster.model.AdminDashboardData;
import com.tablemasteradmin.admintablemaster.model.ApiResponse;
import com.tablemasteradmin.admintablemaster.model.Discount;

import java.io.IOException;
import java.net.http.HttpResponse;

public class AdminService extends MainService {
    public boolean adminLogin(Admin admin) throws IOException {

        Admin adminCredentials = new Admin("Admin", "12345678");

        if (admin.equals(adminCredentials.getEmail()) && admin.equals(adminCredentials.getPassword())) {
            return true;
        }

        return false;
    }

    public AdminDashboardData getAdminDashboardData() throws IOException {
        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

        TypeReference<ApiResponse<AdminDashboardData>> typeRef = new TypeReference<>() {};
        HttpResponse<String> res = getRequest("admin/getAdminDashboardData");
        ApiResponse<AdminDashboardData> apiResponse = mapper.readValue(res.body(), typeRef);

        if (apiResponse.isSuccess()) {
            return apiResponse.getData();
        } else {
            Popup.showPopup(PopupTypeEnum.ERROR, apiResponse.getMessage(), "Error in Retrieving Data");
            return null;
        }
    }

    public boolean updateDiscount(Discount discount) throws IOException {
        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
        String reqBody = mapper.writeValueAsString(discount);

        TypeReference<ApiResponse<Boolean>> typeRef = new TypeReference<>() {};
        HttpResponse<String> res = postRequest("discount/createDiscount", reqBody);

        ApiResponse<Boolean> apiResponse = mapper.readValue(res.body(), typeRef);

        if (apiResponse.isSuccess()) {
            Popup.showPopup(PopupTypeEnum.INFO, apiResponse.getMessage(), "Discount Updated Successfully");
            return true;
        } else {
            Popup.showPopup(PopupTypeEnum.ERROR, apiResponse.getMessage(), "Discount Update Failed");
            return false;
        }
    }
}
