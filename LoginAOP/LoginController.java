package learning.springAOP.LoginAOP;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/home")
public class LoginController {

    @RequestMapping(value = "/login")
    public ModelAndView login(HttpServletRequest request, HttpSession session, int identity){

        System.out.println(identity);

        session = request.getSession();

        //将 identity 的值放到 session 里面
        session.setAttribute("identity", identity);

        return new ModelAndView("home", "msg", "登录成功");

    }


    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request, HttpSession session){
        session = request.getSession();
        String msg = (String) session.getAttribute("msg");

        return new ModelAndView("home", "msg", msg);
    }


    @RequestMapping("/admin")
    public ModelAndView admin(HttpServletRequest request, HttpSession session){
        session = request.getSession();

        String msg = (String) session.getAttribute("msg");

        return new ModelAndView("home", "msg", msg);
    }

}
