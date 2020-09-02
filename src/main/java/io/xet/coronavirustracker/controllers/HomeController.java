package io.xet.coronavirustracker.controllers;

import io.xet.coronavirustracker.models.LocationStats;
import io.xet.coronavirustracker.services.CoronavirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    CoronavirusDataService coronavirusDataService;

    @GetMapping("/")
    public String home(Model model){
        List<LocationStats> allStats = coronavirusDataService.getAllStats();
        int totalCases = allStats
                .stream()
                .mapToInt(value -> Integer.parseInt(value.getLatestReportedCases()))
                .sum();
        int casesInUkraine = allStats
                .stream()
                .filter(locationStats -> locationStats.getCountry().equals("Ukraine"))
                .mapToInt(value -> Integer.parseInt(value.getLatestReportedCases()))
                .sum();
        int totalDailyDifference = allStats
                .stream()
                .mapToInt(value -> value.getDailyDifference())
                .sum();
        int dailyDifferenceInUkraine = allStats
                .stream()
                .filter(locationStats -> locationStats.getCountry().equals("Ukraine"))
                .mapToInt(value -> value.getDailyDifference()).sum();

        model.addAttribute("locationStats", coronavirusDataService.getAllStats());
        model.addAttribute("totalCases", totalCases);
        model.addAttribute("casesInUkraine", casesInUkraine);
        model.addAttribute("totalDailyDifference", totalDailyDifference);
        model.addAttribute("dailyDifferenceInUkraine", dailyDifferenceInUkraine);
        return "home";
    }
}
