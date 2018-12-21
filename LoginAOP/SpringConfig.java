package learning.springAOP.LoginAOP;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "learning.springAOP.LoginAOP")
@EnableAspectJAutoProxy
public class SpringConfig {
}
