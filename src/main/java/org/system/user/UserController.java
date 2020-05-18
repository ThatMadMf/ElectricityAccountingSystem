package org.system.user;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@Controller
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUserInformation(@AuthenticationPrincipal Principal principal, Model model,
                                     Authentication authentication, HttpServletResponse response) {
        if (isAdmin(authentication)) {
            return "admin";
        }
        model.addAttribute("user", userService.getUserInfo(principal.getName()));
        return "user-home";
    }

    private boolean isAdmin(Authentication authentication) {
        String role = authentication.getAuthorities().toArray()[0].toString();
        return role.equals("ROLE_SUPER_ADMIN") || role.equals("ROLE_ADMIN");
    }
}
