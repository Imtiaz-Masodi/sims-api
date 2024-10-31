package app.soft_tenders.sims.util;

public interface Constraints {
    int SCHOOL_ID_MIN_LENGTH = 5;
    int SCHOOL_ID_MAX_LENGTH = 50;
    int SCHOOL_NAME_MIN_LENGTH = 5;
    int SCHOOL_NAME_MAX_LENGTH = 255;

    int USER_NAME_MIN_LENGTH = 3;
    int USER_NAME_MAX_LENGTH = 255;
    int USER_MIN_AGE = 3;
    int USER_MAX_AGE = 120;
    int USER_PASSWORD_MIN_LENGTH = 6;
    int USER_PASSWORD_MAX_LENGTH = 100;
}
