package com.project.project.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main")
public class MainController {
    @GetMapping("/")
    public String hello(@RequestParam(value = "title", defaultValue = "Unite", required = true) String title, @RequestParam(value = "page", defaultValue = "unite", required = true) String page,Model model, HttpSession session, HttpServletRequest request) {
        model.addAttribute("title", title);
        model.addAttribute("page", page);
        return "main-component";
    }

    @GetMapping("/data")
    @ResponseBody
    public Map<String, List<String>> getData() {
        List<String> data = new ArrayList<>();
        data.add("NyAro");
        data.add("Randy");

        Map<String, List<String>> result = new HashMap<>();
        result.put("data", data);

        return result;
    }
}
