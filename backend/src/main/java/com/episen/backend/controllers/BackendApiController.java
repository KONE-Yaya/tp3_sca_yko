package com.episen.backend.controllers;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api/backend")
public class BackendApiController {

    final Logger LOGGER = Logger.getLogger(BackendApiController.class.getName());

    final String USER_NAME = "YKO";
    final String APP_NAME = "BACKEND";
    final String SCHOOL = "EPISEN SI";
    final String CLASS = "ING3 FISA";
    final int YEAR = 2022;

    @GetMapping("/")
    public String getBackendApiInfos() {

        LOGGER.info("BACKEND API: Beginning of treatment...");

        JSONObject infosObject = new JSONObject();
        infosObject.put("app",APP_NAME);
        infosObject.put("username",USER_NAME);
        infosObject.put("school",SCHOOL);
        infosObject.put("class",CLASS);
        infosObject.put("year",YEAR);

        LOGGER.info("BACKEND API: End of treatment.");

        return JSONObject.valueToString(infosObject);
    }

}
