package com.tablemasteradmin.admintablemaster.HelperFunction;

public enum DomainNames {
    GMAIL("gmail.com"),
    YAHOO("yahoo.com"),
    OUTLOOK("outlook.com"),
    HOTMAIL("hotmail.com"),
    ICLOUD("icloud.com"),
    AOL("aol.com"),
    PROTONMAIL("protonmail.com"),
    MAIL("mail.com"),
    YANDEX("yandex.com"),
    ZOHO("zoho.com");

    private final String domain;

    DomainNames(String domain) {
        this.domain = domain;
    }
    public String getDomain() {
        return domain;
    }
}
