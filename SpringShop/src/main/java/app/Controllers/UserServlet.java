package app.Controllers;


import app.Entities.UserEntity;
import app.Entities.UserOrderViewEntity;
import app.Service.UserOrderService;
import app.Service.UserService;
import app.config.SpringConfig;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/authUser"})
public class UserServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        main.java.app.Util.HibernateSessionFactoryUtil.getSessionFactory();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = SpringConfig.getContext().getBean("userService", UserService.class);
        if (request.getServletPath().equals("/authUser")) {//авторизация
            RequestDispatcher requestDispatcher;
            try {
                UserEntity authUser = userService.authorization(request.getParameter("login"), request.getParameter("password"));
                if (authUser != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("authUser", authUser);
                    UserOrderService orderService = SpringConfig.getContext().getBean("userOrderService",UserOrderService.class);
                    List<UserOrderViewEntity> orderList = orderService.getUserOrderViewList((UserEntity) session.getAttribute("authUser"));
                    request.setAttribute("UserOrders", orderList);
                    requestDispatcher = request.getRequestDispatcher("./view/listUserOrder.jsp");
                } else {
                    request.setAttribute("userIsAuth", "false");
                    requestDispatcher = request.getRequestDispatcher("index.jsp");
                }
                requestDispatcher.forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


