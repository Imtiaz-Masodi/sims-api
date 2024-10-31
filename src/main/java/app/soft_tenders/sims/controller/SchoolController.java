package app.soft_tenders.sims.controller;

import app.soft_tenders.sims.entity.School;
import app.soft_tenders.sims.pojo.ApiResponse;
import app.soft_tenders.sims.pojo.ExecutionResult;
import app.soft_tenders.sims.service.SchoolService;
import app.soft_tenders.sims.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @PostMapping("/create")
    public ApiResponse<School> createSchoolAccount(@RequestBody School school) {
        try {
            ExecutionResult<School> result = schoolService.createSchoolAccount(school);
            if (result.isSuccess())
                return new ApiResponse<>(true, Constants.SCHOOL_ACCOUNT_CREATED, result.getPayload());
            else
                return new ApiResponse<>(false, result.getErrorMessage());
        } catch (Exception e) {
            return new ApiResponse<>(false, e.getMessage());
        }
    }
}
