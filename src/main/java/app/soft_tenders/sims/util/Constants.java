package app.soft_tenders.sims.util;

public interface Constants {
    String SIMS_API_WORKING = "SIMS Api server is up and running!";
    String SCHOOL_ID_REQUIRED = "School Id is required";
    String SCHOOL_ID_MIN_LENGTH_ERROR = String.format("School Id should be at least %d characters long", Constraints.SCHOOL_ID_MIN_LENGTH);
    String SCHOOL_ID_MAX_LENGTH_ERROR = String.format("School Id should be at most %d characters long", Constraints.SCHOOL_ID_MAX_LENGTH);
    String SCHOOL_NAME_REQUIRED = "School Name is required";
    String SCHOOL_NAME_MIN_LENGTH_ERROR = String.format("School Name should be at least %d characters long", Constraints.SCHOOL_NAME_MAX_LENGTH);
    String SCHOOL_NAME_MAX_LENGTH_ERROR = String.format("School Name should be at most %d characters long", Constraints.SCHOOL_NAME_MAX_LENGTH);
    String SCHOOL_PHONE_NUMBER_REQUIRED = "School Phone Number is required";
    String INVALID_PHONE_NUMBER = "Invalid phone number";
    String INVALID_EMAIL_ADDRESS = "Invalid email id";
    String INVALID_WEBSITE = "Invalid website";
    String SCHOOL_ID_IN_USE = "Entered school id is already in use. Please recheck the school id";
    String SCHOOL_ACCOUNT_CREATED = "School account created successfully!";

    String USER_NAME_REQUIRED = "Username is required";
    String USER_NAME_MIN_LENGTH_ERROR = String.format("Username should be at least %d characters long", Constraints.USER_NAME_MIN_LENGTH);
    String USER_NAME_MAX_LENGTH_ERROR = String.format("Username should be at most %d characters long", Constraints.USER_NAME_MAX_LENGTH);
    String USER_MIN_AGE_ERROR = String.format("User's age should be at least %d years", Constraints.USER_MIN_AGE);
    String USER_MAX_AGE_ERROR = String.format("User's age should be at most %d years", Constraints.USER_MAX_AGE);
    String USER_PASSWORD_REQUIRED = "Password is required";
    String USER_PASSWORD_MIN_LENGTH_ERROR = String.format("Password should be at lease %d characters long", Constraints.USER_PASSWORD_MIN_LENGTH);
    String USER_PASSWORD_MAX_LENGTH_ERROR = String.format("Password should be at most %d characters long", Constraints.USER_PASSWORD_MAX_LENGTH);
    String USER_EXISTS_WITH_EMAIL_ID = "User already exists with specified email address";
    String USER_ACCOUNT_CREATED = "User account create successfully!";
    String USER_DETAILS_FOUND = "User details found";
    String USER_DETAILS_NOT_FOUND = "User details not found";
    String USER_ACCOUNT_DEACTIVATED = "User account deactivated";

    String REGEX_EMAIL_ADDRESS = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    String REGEX_URL = "^(https?://)?(www\\.)?[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}(/.*)?$";
    String REGEX_MOBILE_NUMBER = "^(?:\\+91|91|0)?[789]\\d{9}$";

    String LOGIN_SUCCESS = "Login success!";
    String TOKEN_EXPIRED = "Token expired";

    static String userNotFoundWithEmail(String email) {
        return String.format("User not found with email %s", email);
    }

    static String errorOccurred(String message) {
        return String.format("Error occurred! %s", message);
    }
}
