package main.java.app.Controllers;


import main.java.app.Entities.UserEntity;
import main.java.app.Entities.UserOrderEntity;
import main.java.app.Entities.UserOrderViewEntity;
import main.java.app.Service.ProductService;
import main.java.app.Service.UserOrderService;
import main.java.app.Util.SpringConfig;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/addOrder", "/listUserOrder", "/delOrder"})
public class OrderServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserOrderService orderService = SpringConfig.getContext().getBean("userOrderService", UserOrderService.class);
        if (request.getServletPath().equals("/addOrder")) {
            UserOrderEntity userOrderEntity = new UserOrderEntity();
            UserEntity userEntity = (UserEntity) session.getAttribute("authUser");
            userOrderEntity.setShuser(userEntity.getIduser());
            userOrderEntity.setProduct(Integer.parseInt(request.getParameter("idProduct")));
            userOrderEntity.setCount(1);
            orderService.addOrder(userOrderEntity);
        }
        if (request.getServletPath().equals("/delOrder")) {
            orderService.delOrder(Integer.parseInt(request.getParameter("idOrder")));
        }
        List<UserOrderViewEntity> orderList = orderService.getUserOrderViewList((UserEntity) session.getAttribute("authUser"));
        request.setAttribute("UserOrders", orderList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/listUserOrder.jsp");
        requestDispatcher.forward(request, response);
    }
}


