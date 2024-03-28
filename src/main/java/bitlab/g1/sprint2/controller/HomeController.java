package bitlab.g1.sprint2.controller;

import bitlab.g1.sprint2.entity.ApplicationRequest;
import bitlab.g1.sprint2.entity.Role;
import bitlab.g1.sprint2.entity.User;
import bitlab.g1.sprint2.service.ApplicationRequestService;
import bitlab.g1.sprint2.service.RoleService;
import bitlab.g1.sprint2.service.UserService;
import java.io.Reader;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

  @Autowired
  private ApplicationRequestService applicationRequestService;
  @Autowired
  private UserService userService;
  @Autowired
  private RoleService roleService;

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

  @GetMapping("/user")
  public String usersPage(Model model) {
    List<User> users = userService.getUsers();
    model.addAttribute("users", users);
    return "users";
  }

  @GetMapping("/user/{id}")
  public String userDetails(@PathVariable Long id, Model model,
      Reader reader) {
    User user = userService.getUserById(id);
    model.addAttribute("user", user);
    List<Role> roles = roleService.getRoles();
    roles.removeAll(user.getRole());
    model.addAttribute("roles", roles);
    return "userDetails";
  }

  @PostMapping("/user/role/add")
  public String addRoleToUser(@RequestParam Long userId, @RequestParam Long roleId) {
    userService.addRoleToUser(userId, roleId);
    return "redirect:/user/" + userId;
  }

  @PostMapping("/user/role/remove")
  public String removeRoleFromUser(@RequestParam Long userId, @RequestParam Long roleId) {
    userService.removeRoleFromUser(userId, roleId);
    return "redirect:/user/" + userId;
  }

}
