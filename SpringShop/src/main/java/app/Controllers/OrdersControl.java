package app.Controllers;

import app.Entities.UserEntity;
import app.Entities.UserOrderEntity;
import app.Entities.UserOrderViewEntity;
import app.Service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/users/orders")
public class OrdersControl extends HttpServlet {
    private final UserOrderService userOrderService;

    @Autowired
    public OrdersControl(UserOrderService userOrderService) {
        this.userOrderService = userOrderService;
    }

    @GetMapping()
    public String UserOrders(Model model, HttpSession session) {
        List<UserOrderViewEntity> orderList = userOrderService.getUserOrderViewList((UserEntity) session.getAttribute("authUser"));
        model.addAttribute("UserOrders", orderList);
        return "listUserOrder";
    }

    @GetMapping("delOrder/{idOrder}")
    public String delOrder(@PathVariable("idOrder") Integer idOrder) {
        userOrderService.delOrder(idOrder);
        return "redirect:/users/orders";
    }

    @GetMapping("addOrder/{idProduct}")
    public String addOrder(@PathVariable("idProduct") Integer idProduct, HttpSession session) {
        UserOrderEntity userOrderEntity = new UserOrderEntity();
        UserEntity user = (UserEntity) session.getAttribute("authUser");
        userOrderEntity.setShuser(user.getIduser());
        userOrderEntity.setProduct(idProduct);
        userOrderEntity.setCount(1);
        userOrderService.addOrder(userOrderEntity);
        return "redirect:/users/orders";
    }
}


