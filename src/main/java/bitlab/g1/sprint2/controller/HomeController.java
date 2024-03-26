package bitlab.g1.sprint2.controller;

import bitlab.g1.sprint2.entity.ApplicationRequest;
import bitlab.g1.sprint2.service.ApplicationRequestService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @Autowired
  private ApplicationRequestService applicationRequestService;

  @GetMapping("/")
  public String homePage(Model model) {
    List<ApplicationRequest> applicationRequests = applicationRequestService.getApplicationRequests();
    model.addAttribute("zayavki", applicationRequests);
    return "home";
  }

  @GetMapping("/app-req/handled")
  public String handledApplicationRequests(Model model) {
    List<ApplicationRequest> applicationRequests = applicationRequestService.getHandledAppRequests();
    model.addAttribute("zayavki", applicationRequests);
    return "home";
  }
}
