package com.theironyard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.Period;

/**
 * Created by Zach on 10/7/16.
 */
@Controller
public class AgeCalculatorController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {
        String birthday = (String) session.getAttribute("birthday");
        if (birthday == null) {
            birthday = LocalDate.now().toString();
        }
        Period p = Calculator.calculateAge(birthday);
        int years = p.getYears();
        int months = years * 12;
        int days = months * 30;
        int hours =  days * 24;
        int minutes = hours * 60;
        int seconds = minutes * 60;

        CurrentAge age = new CurrentAge(years, months, days, hours, minutes,seconds);

        model.addAttribute("currentAge", age);
        return "home";
    }

    @RequestMapping(path = "/get-birthday", method = RequestMethod.POST)
    public String getBirthday(HttpSession session, String birthday) {
        session.setAttribute("birthday", birthday);

        return "redirect:/";
    }
}
