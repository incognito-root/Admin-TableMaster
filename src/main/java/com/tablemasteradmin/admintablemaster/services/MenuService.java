package com.tablemasteradmin.admintablemaster.services;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.tablemasteradmin.admintablemaster.HelperFunction.Popup;
import com.tablemasteradmin.admintablemaster.HelperFunction.PopupTypeEnum;
import com.tablemasteradmin.admintablemaster.model.Admin;
import com.tablemasteradmin.admintablemaster.model.ApiResponse;
import com.tablemasteradmin.admintablemaster.model.MenuItemModel;
import com.tablemasteradmin.admintablemaster.model.UpdateMenuItem;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class MenuService extends MainService {
    private ArrayList<MenuItemModel> allMenuItems = new ArrayList<>();

    private void readAllMenuItems() throws IOException {
        HttpResponse<String> result = getRequest("menu/getAllMenuItems");

        ObjectMapper mapper = new ObjectMapper()
                .registerModule(new JavaTimeModule());

        TypeReference<ApiResponse<ArrayList<MenuItemModel>>> typeRef = new TypeReference<>() {};
        ApiResponse<ArrayList<MenuItemModel>> apiResponse = mapper.readValue(result.body(), typeRef);

        if (apiResponse.isSuccess()) {
            allMenuItems = apiResponse.getData();
        } else {
            Popup.showPopup(PopupTypeEnum.ERROR, apiResponse.getMessage(), "Menu Items Error");
        }
    }

    public void setAllMenuItems() throws IOException {
        readAllMenuItems();
    }

    public ArrayList<MenuItemModel> getAllMenuItems() {
        return allMenuItems;
    }

    public boolean savemenuitem(MenuItemModel menuitem) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        String reqBody = mapper.writeValueAsString(menuitem);

        TypeReference<ApiResponse<Boolean>> typeRef = new TypeReference<>() {};
        HttpResponse<String> result = postRequest("menu/addMenuItem", reqBody);

        ApiResponse<Boolean> apiResponse = mapper.readValue(result.body(), typeRef);

        if (apiResponse.isSuccess()) {
            Popup.showPopup(PopupTypeEnum.INFO, apiResponse.getMessage(), "Menu Items Saved");
            return true;
        } else {
            Popup.showPopup(PopupTypeEnum.ERROR, apiResponse.getMessage(), "Menu Items Error");
            return false;
        }
    }

    public boolean updateMenuItem(UpdateMenuItem menuitem) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        String reqBody = mapper.writeValueAsString(menuitem);

        TypeReference<ApiResponse<Boolean>> typeRef = new TypeReference<>() {};
        HttpResponse<String> result = postRequest("menu/updateMenuItem", reqBody);

        ApiResponse<Boolean> apiResponse = mapper.readValue(result.body(), typeRef);

        if (apiResponse.isSuccess()) {
            Popup.showPopup(PopupTypeEnum.INFO, apiResponse.getMessage(), "Menu Item Updated");
            return true;
        } else {
            Popup.showPopup(PopupTypeEnum.ERROR, apiResponse.getMessage(), "Menu Item Error");
            return false;
        }
    }

}
