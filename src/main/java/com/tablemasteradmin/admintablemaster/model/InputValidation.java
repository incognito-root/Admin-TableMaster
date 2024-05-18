package com.tablemasteradmin.admintablemaster.model;

import javafx.scene.control.Label;

public class InputValidation {
    public static String errorMessage = "";

    public static void setErrors(Label label) {
        String labelText = label.getText();
        String completeError = labelText + " " + errorMessage;
        label.setText(completeError);
        label.setStyle("-fx-text-fill: red;");
    }

    public static void clearErrors(Label label, String originalLabel) {
        errorMessage = "";
        label.setText(originalLabel);
        label.setStyle("-fx-text-fill: #D9D9D9;");
    }

    public static boolean validateAlpha(String stringToCheck) {
        if (stringToCheck == null || stringToCheck.isEmpty()) {
            errorMessage = ": cannot be empty";
            return false;
        }

        if (!stringToCheck.chars().allMatch(Character::isAlphabetic)) {
            errorMessage = ": only alphabets allowed";
            return false;
        }

        return true;
    }

    public static boolean validateLength(String stringToCheck, int minLength) {
        if (stringToCheck == null || stringToCheck.isEmpty()) {
            errorMessage = ": cannot be empty";
            return false;
        }

        if (stringToCheck.length() < minLength) {
            errorMessage = ": minimum length " + minLength;
            return false;
        }

        return true;
    }

    public static boolean validateLength(String stringToCheck, int minLength, int maxLength) {
        if (stringToCheck == null || stringToCheck.isEmpty()) {
            errorMessage = ": cannot be empty";
            return false;
        }

        if (stringToCheck.length() < minLength || stringToCheck.length() > maxLength) {
            errorMessage = ": length between " + minLength + " and " + maxLength;
            return false;
        }

        return true;
    }

    public static boolean validateEmail(String stringToCheck) {
        if (stringToCheck == null || stringToCheck.isEmpty()) {
            errorMessage = ": cannot be empty";
            return false;
        }

        if (!validateLength(stringToCheck, 5, 320)) {
            errorMessage = ": length between 5 and 320";
            return false;
        }

        if (!stringToCheck.contains("@")) {
            errorMessage = ": invalid format";
            return false;
        }

        return true;
    }

    public static boolean isDigits(String stringToCheck) {
        if (stringToCheck == null || stringToCheck.isEmpty()) {
            errorMessage = ": cannot be empty";
            return false;
        }

        if (!stringToCheck.matches("[0-9]+")) {
            errorMessage = ": invalid format";
            return false;
        }

        return true;
    }

    public static boolean validatePasswordMatch(String password, String confirmPassword) {
        if (password == null || password.isEmpty() || confirmPassword == null || confirmPassword.isEmpty()) {
            errorMessage = ": cannot be empty";
            return false;
        }

        if (!password.equals(confirmPassword)) {
            errorMessage = ": passwords do not match";
            return false;
        }

        return true;
    }
}