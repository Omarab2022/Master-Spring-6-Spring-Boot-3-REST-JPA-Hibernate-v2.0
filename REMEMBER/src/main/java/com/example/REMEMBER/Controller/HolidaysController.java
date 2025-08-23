package com.example.REMEMBER.Controller;


import com.example.REMEMBER.Model.Holiday;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HolidaysController {



//    this exemple is for @RequestParam

//    @GetMapping("/holidays")
//    public String displayHolidays(@RequestParam(required = false , name = "festival") boolean fest,
//                                  @RequestParam(required = false) boolean federal
//            , Model model) {
//
//        model.addAttribute("festival", fest);
//        model.addAttribute("federal", federal);
//
//        List<Holiday> holidays = Arrays.asList(
//                new Holiday("Jan 1", "new year'day", Holiday.Type.FESTIVAL),
//                new Holiday("Jan 26", "Republic Day", Holiday.Type.FEDERAL),
//                new Holiday("Feb 14", "Valentine's Day", Holiday.Type.FESTIVAL)
//
//
//        );
//        Holiday.Type[] types = Holiday.Type.values();
//        for (Holiday.Type type : types) {
//            model.addAttribute(type.toString(),
//                    (holidays.stream().filter(holiday -> holiday.getType().equals(type)).collect(Collectors.toList())));
//        }
//        return "holidays.html";
//    }


    @GetMapping("/holidays/{display}")
    public String displayHolidays(@PathVariable String display , Model model) {


        if(null != display && display.equals("all")){
            model.addAttribute("festival" , true);
            model.addAttribute("federal" , true);
        }else if( null != display && display.equals("festival")) {
            model.addAttribute("festival", true);
        }else if ( null != display && display.equals("federal")){
            model.addAttribute("federal" , true);
        }

        List<Holiday> holidays = Arrays.asList(
                new Holiday("Jan 1", "new year'day", Holiday.Type.FESTIVAL),
                new Holiday("Jan 26", "Republic Day", Holiday.Type.FEDERAL),
                new Holiday("Feb 14", "Valentine's Day", Holiday.Type.FESTIVAL)


        );
        Holiday.Type[] types = Holiday.Type.values();
        for (Holiday.Type type : types) {
            model.addAttribute(type.toString(),
                    (holidays.stream().filter(holiday -> holiday.getType().equals(type)).collect(Collectors.toList())));
        }
        return "holidays.html";
    }
}
