package controllers;

import dao.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.InfoService;

/**
 * Должна использоваться rest-архитектура
 */
@Controller
public class MainController {

    private InfoService infoService;

    @Autowired
    public MainController(InfoService infoService) {
        this.infoService = infoService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/showAll", method = RequestMethod.GET)
    public String showAll(Model model) {
        model.addAttribute("infoList", infoService.findAll());
        return "showAll";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAdd(Model model) {
        model.addAttribute("isEdit", false);
        return "add_edit";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAdd(Info info) {
        infoService.save(info);
        return "redirect:/showAll";
    }

    @RequestMapping(value = "/delete/{infoId}", method = RequestMethod.GET)
    public String delete(@PathVariable("infoId") String infoId) {
        infoService.delete(Integer.parseInt(infoId));
        return "redirect:/showAll";
    }

    @RequestMapping(value = "/edit/{infoId}", method = RequestMethod.GET)
        public String showEdit(Model model, @PathVariable("infoId") String infoId) {
        Info editedInfo = infoService.getById(Integer.parseInt(infoId));
        model.addAttribute("isEdit", true);
        model.addAttribute("info", editedInfo);
        return "add_edit";
    }

    @RequestMapping(value = "/edit/{infoId}", method = RequestMethod.POST)
    public String processEdit(Info info) {
        infoService.edit(info);
        return "redirect:/showAll";
    }
}