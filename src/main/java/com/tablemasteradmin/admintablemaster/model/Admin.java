package com.tablemasteradmin.admintablemaster.model;


import com.tablemasteradmin.admintablemaster.HelperFunction.DomainNames;
import com.tablemasteradmin.admintablemaster.HelperFunction.EmailException;

public class Admin {
    private String username;
    private String password;
    private String email;

    public Admin(String username, String password, String email) {
        setPassword(password);
        setUsername(username);
        try {
            setEmail(email);
        } catch (EmailException e) {
            System.out.println("I+nvalid email");

        }
    }

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Admin() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws EmailException {
        if (validemail(email)) {
            this.email = email;
        } else {
            throw new EmailException("Invalid email");
        }
    }

    public boolean validemail(String email) {
        boolean valid = true;
        if (email.contains(" ")) {
            valid = false;
        } else if (email.isEmpty()) {
            valid = false;
        } else if (email.contains("@")) {
            int index = email.indexOf("@");
            String domain = email.substring(index);
            for (DomainNames d : DomainNames.values()) {
                if (domain.contains(d.getDomain())) {
                    valid = true;
                } else {
                    valid = false;
                }
            }
        } else {
            valid = false;
        }

        return valid;
    }


}

