/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unu.jogja.project.ktp;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author RIVKY RIYANTORO
 */
@Controller
public class dataController {
       
    DataJpaController ctrl = new DataJpaController();
    List<Data> newData = new ArrayList<>();
    
    @RequestMapping("/data")
    //@ResponseBody
    public String getDataKTP(Model model) {
        int record = ctrl.getDataCount();
        String result ="";
        try {
            newData = ctrl.findDataEntities().subList(0, record);
        } catch (Exception e) {
            result=e.getMessage();
        }
        model.addAttribute("newData", newData);
        model.addAttribute("record", record);
        
        
        return "database";
    }
    
}
