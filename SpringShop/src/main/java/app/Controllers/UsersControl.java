package app.Controllers;


import app.Entities.UserEntity;
import app.Entities.UserOrderViewEntity;
import app.Service.UserOrderService;
import app.Service.UserService;
import app.config.SpringConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Access;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersControl {
    private final UserService userService;

    @Autowired
    public UsersControl(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/auth")
    public String auth(HttpSession session,UserEntity userEntity){
      UserEntity authUser=  userService.authorization(userEntity);
        if (authUser != null) {
            session.setAttribute("authUser", authUser);
            return "redirect:./orders";
        }
        return "redirect:/";
    }
}


