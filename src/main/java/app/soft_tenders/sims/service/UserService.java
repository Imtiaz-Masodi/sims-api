package app.soft_tenders.sims.service;

import app.soft_tenders.sims.entity.User;
import app.soft_tenders.sims.pojo.ExecutionResult;
import app.soft_tenders.sims.repository.UserRepo;
import app.soft_tenders.sims.util.Constants;
import app.soft_tenders.sims.util.Constraints;
import app.soft_tenders.sims.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public String isValidUserObj(User user) {
        if (StringUtils.isNullOrEmpty(user.getName()))
            return Constants.USER_NAME_REQUIRED;
        else if (user.getName().length() < Constraints.USER_NAME_MIN_LENGTH)
            return Constants.USER_NAME_MIN_LENGTH_ERROR;
        else if (user.getName().length() > Constraints.USER_NAME_MAX_LENGTH)
            return Constants.USER_NAME_MAX_LENGTH_ERROR;
        else if (user.getAge() != 0 && user.getAge() < Constraints.USER_MIN_AGE)
            return Constants.USER_MIN_AGE_ERROR;
        else if (user.getAge() != 0 && user.getAge() > Constraints.USER_MAX_AGE)
            return Constants.USER_MAX_AGE_ERROR;
        else if (StringUtils.isNullOrEmpty(user.getPassword()))
            return Constants.USER_PASSWORD_REQUIRED;
        else if (user.getPassword().length() < Constraints.USER_PASSWORD_MIN_LENGTH)
            return Constants.USER_PASSWORD_MIN_LENGTH_ERROR;
        else if (user.getPassword().length() > Constraints.USER_PASSWORD_MAX_LENGTH)
            return Constants.USER_PASSWORD_MAX_LENGTH_ERROR;
        return null;
    }

    public ExecutionResult<User> createUser(User user) {
        try {
            user.setCreatedOn(LocalDateTime.now());
            User createdUser = userRepo.save(user);
            return new ExecutionResult<>(createdUser);
        } catch (Exception e) {
            return new ExecutionResult<>(e.getMessage());
        }
    }

    public boolean isUserExistsWithEmailId(String emailId) {
        try {
            List<User> users = userRepo.findByEmailId(emailId);
            return users != null && !users.isEmpty();
        } catch (Exception e) {
            return false;
        }
    }
}
