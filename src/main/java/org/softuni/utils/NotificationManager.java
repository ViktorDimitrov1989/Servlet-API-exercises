package org.softuni.utils;

import javax.servlet.http.HttpServletRequest;

public class NotificationManager {

    private NotificationManager(){
    }

    public static void clearNotifications(HttpServletRequest req){
        req.getSession().setAttribute("error", null);
        req.getSession().setAttribute("info", null);
    }



}
