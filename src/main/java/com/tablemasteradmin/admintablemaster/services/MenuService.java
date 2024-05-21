package com.tablemasteradmin.admintablemaster.services;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.tablemasteradmin.admintablemaster.model.Admin;
import com.tablemasteradmin.admintablemaster.model.MenuItemModel;
import com.tablemasteradmin.admintablemaster.model.UpdateMenuItem;

import java.io.IOException;
import java.util.ArrayList;

public class MenuService extends MainService {
    private ArrayList<MenuItemModel> allMenuItems = new ArrayList<>();

    private void readAllMenuItems() throws IOException {
        String result = getRequest("menu/getAllMenuItems").body();

        ObjectMapper mapper = new ObjectMapper()
                .registerModule(new JavaTimeModule());

        this.allMenuItems = mapper.readValue(result, new TypeReference<ArrayList<MenuItemModel>>() {
        });
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

        int result = postRequest("menu/addMenuItem", reqBody).statusCode();

        return result == 200; // OK
    }

    public boolean updateMenuItem(UpdateMenuItem menuitem) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        String reqBody = mapper.writeValueAsString(menuitem);

        int result = postRequest("menu/updateMenuItem", reqBody).statusCode();

        return result == 200; // OK
    }

}
