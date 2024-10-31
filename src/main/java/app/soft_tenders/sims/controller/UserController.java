package app.soft_tenders.sims.controller;

import app.soft_tenders.sims.entity.User;
import app.soft_tenders.sims.pojo.ApiResponse;
import app.soft_tenders.sims.repository.UserRepo;
import app.soft_tenders.sims.service.UserService;
import app.soft_tenders.sims.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/me")
    public ApiResponse<User> getSelfDetails() {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String emailId = auth.getName();
            List<User> users = userRepo.findByEmailId(emailId);
            if (users.isEmpty()) return new ApiResponse<>(false, Constants.USER_DETAILS_NOT_FOUND);

            return new ApiResponse<>(true, Constants.USER_DETAILS_FOUND, users.getFirst());
        } catch (Exception e) {
            return new ApiResponse<>(false, e.getMessage());
        }
    }
}
