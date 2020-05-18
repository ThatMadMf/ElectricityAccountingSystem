package org.system.user;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.system.account.AccountDto;

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

    @GetMapping("new-account")
    public String addAccount(Model model) {
        model.addAttribute("account", new AccountDto());
        return "new-account";
    }

    @PostMapping("new-account")
    public String processNewAccount(@AuthenticationPrincipal Principal principal,
                                    @ModelAttribute AccountDto accountDto, Model model) {

        userService.addAccount(accountDto, principal.getName());

        model.addAttribute("success", true);

        return "submission-result";
    }

    private boolean isAdmin(Authentication authentication) {
        String role = authentication.getAuthorities().toArray()[0].toString();
        return role.equals("ROLE_SUPER_ADMIN") || role.equals("ROLE_ADMIN");
    }
}
