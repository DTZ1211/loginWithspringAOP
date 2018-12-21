package learning.springAOP.LoginAOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Component
@Aspect
public class LoginAdvice {

    @Around("execution(* learning.springAOP.LoginAOP.LoginController.index(..))")
    public Object indexcheck(ProceedingJoinPoint jp) throws Throwable {

        //获取 HttpServletRequest 对象
        HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        HttpSession session =request.getSession();

        int identity = (int) session.getAttribute("identity");

        session.setAttribute("msg", "你好亲爱的用户");

        return jp.proceed();
    }

    @Around("execution(* learning.springAOP.LoginAOP.LoginController.admin(..))")
    public Object admincheck(ProceedingJoinPoint jp) throws Throwable {
        //获取 HttpServletRequest 对象
        HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        HttpSession session = request.getSession();
        int identity = (int) session.getAttribute("identity");

        if (identity == 2){
            session.setAttribute("msg", "欢迎您管理员");
        }else {
            session.setAttribute("msg", "您没有权限访问该页面");
        }

        return jp.proceed();
    }

}
