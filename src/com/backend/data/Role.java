package com.backend.data;

public class Role {
    public static final String GUIDE = "guide";
    public static final String EMPLOYEE = "employee";
    public static final String ADMIN = "admin";

    private Role() {
        // Static methods and fields only
    }

    public static String[] getAllRoles() {
        return new String[] { GUIDE, EMPLOYEE, ADMIN };
    }
}
