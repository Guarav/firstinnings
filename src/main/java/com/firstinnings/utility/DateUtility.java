package com.firstinnings.utility;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utility class to perform operations related to Date.
 */
@Component
public class DateUtility {

    /**
     * This method is responsible for converting the string date to Date object.
     * @param date
     * @return
     */
    public Date convertToDate(String date) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            return dateFormat.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
            // todo : add something here to inform the client of the failure.?
        }
        return null;
    }
}
