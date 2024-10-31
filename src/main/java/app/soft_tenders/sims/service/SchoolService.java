package app.soft_tenders.sims.service;

import app.soft_tenders.sims.entity.School;
import app.soft_tenders.sims.pojo.ExecutionResult;
import app.soft_tenders.sims.repository.SchoolRepo;
import app.soft_tenders.sims.util.Constants;
import app.soft_tenders.sims.util.Constraints;
import app.soft_tenders.sims.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SchoolService {
    @Autowired
    private SchoolRepo schoolRepo;

    public String isValidSchoolObj(School school) {
        if (StringUtils.isNullOrEmpty(school.getSchoolId()))
            return Constants.SCHOOL_ID_REQUIRED;
        else if (school.getSchoolId().length() < Constraints.SCHOOL_ID_MIN_LENGTH)
            return Constants.SCHOOL_ID_MIN_LENGTH_ERROR;
        else if (school.getSchoolId().length() > Constraints.SCHOOL_ID_MAX_LENGTH)
            return Constants.SCHOOL_ID_MAX_LENGTH_ERROR;
        else if (StringUtils.isNullOrEmpty(school.getName()))
            return Constants.SCHOOL_NAME_REQUIRED;
        else if (school.getName().length() < Constraints.SCHOOL_NAME_MIN_LENGTH)
            return Constants.SCHOOL_NAME_MIN_LENGTH_ERROR;
        else if (school.getName().length() > Constraints.SCHOOL_NAME_MIN_LENGTH)
            return Constants.SCHOOL_NAME_MAX_LENGTH_ERROR;
        else if (StringUtils.isNullOrEmpty(school.getPhoneNumber()))
            return Constants.SCHOOL_PHONE_NUMBER_REQUIRED;
        else if (!StringUtils.isValidMobileNumber(school.getPhoneNumber()))
            return Constants.INVALID_PHONE_NUMBER;
        else if (school.getEmailAddress() != null && !StringUtils.isValidEmailAddress(school.getEmailAddress()))
            return Constants.INVALID_EMAIL_ADDRESS;
        else if (school.getWebsite() != null && !StringUtils.isValidUrl(school.getWebsite()))
            return Constants.INVALID_WEBSITE;
        else if (!schoolRepo.findBySchoolId(school.getSchoolId()).isEmpty())
            return Constants.SCHOOL_ID_IN_USE;
        return null;
    }

    @Transactional
    public ExecutionResult<School> createSchoolAccount(School school) {
        try {
            String validationRes = isValidSchoolObj(school);
            if (validationRes != null)
                return new ExecutionResult<>(Constants.errorOccurred(validationRes));

            School createSchool = schoolRepo.save(school);
            return new ExecutionResult<>(createSchool);
        } catch (Exception e) {
            return new ExecutionResult<>(Constants.errorOccurred(e.getMessage()));
        }
    }
}
