package app.soft_tenders.sims.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    public static boolean isNullOrEmpty(String text) {
        return text == null || text.isBlank();
    }

    public static boolean isValidEmailAddress(String emailId) {
        return matchRegex(Constants.REGEX_EMAIL_ADDRESS, emailId);
    }

    public static boolean isValidMobileNumber(String mobileNo) {
        return matchRegex(Constants.REGEX_MOBILE_NUMBER, mobileNo);
    }

    public static boolean isValidUrl(String url) {
        return matchRegex(Constants.REGEX_URL, url);
    }

    private static boolean matchRegex(String regex, String text) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }
}
