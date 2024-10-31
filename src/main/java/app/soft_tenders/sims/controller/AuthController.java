package app.soft_tenders.sims.controller;

import app.soft_tenders.sims.entity.User;
import app.soft_tenders.sims.pojo.ApiResponse;
import app.soft_tenders.sims.pojo.ExecutionResult;
import app.soft_tenders.sims.repository.UserRepo;
import app.soft_tenders.sims.service.UserService;
import app.soft_tenders.sims.util.Constants;
import app.soft_tenders.sims.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JwtUtil jwtUtil;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/signup")
    public ApiResponse<?> signup(@RequestBody User user) {
        try {
            String userObjValidationMsg = userService.isValidUserObj(user);
            if (userObjValidationMsg != null) {
                return new ApiResponse<>(false, userObjValidationMsg);
            }

            // Check whether user with email id already exists
            if (userService.isUserExistsWithEmailId(user.getEmailId())) {
                return new ApiResponse<>(false, Constants.USER_EXISTS_WITH_EMAIL_ID);
            }

            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setActive(true);
            ExecutionResult<User> result = userService.createUser(user);
            if (result.isSuccess()) {
                return new ApiResponse<>(true, Constants.USER_ACCOUNT_CREATED, result.getPayload());
            } else {
                return new ApiResponse<>(false, result.getErrorMessage());
            }
        } catch (Exception e) {
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    @PostMapping("/login")
    public ApiResponse<String> login(@RequestBody User user) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmailId(), user.getPassword()));
            User loggingUser = userRepo.findByEmailId(user.getEmailId()).getFirst();
            String jwt = jwtUtil.generateToken(loggingUser.getEmailId(), getUserClaims(loggingUser));
            return new ApiResponse<>(true, Constants.LOGIN_SUCCESS, jwt);
        } catch (Exception e) {
            return new ApiResponse<>(false, e.getMessage());
        }
    }

    public Map<String, Object> getUserClaims(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("name", user.getName());
        claims.put("uid", user.getId());
        claims.put("role", user.getRole());
        return claims;
    }
}
