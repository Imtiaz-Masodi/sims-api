package app.soft_tenders.sims.controller;

import app.soft_tenders.sims.repository.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static app.soft_tenders.sims.util.Constants.SIMS_API_WORKING;

@RestController
@RequestMapping("/status")
public class IndexController {
    @Autowired
    private UserRepo userRepo;

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @GetMapping
    public String status() {
        logger.info(SIMS_API_WORKING);
        return SIMS_API_WORKING;
    }

}