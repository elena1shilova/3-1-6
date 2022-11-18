package spring.example.org;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.Commun;
import spring.config.MyConfig;
import spring.models.User;

import java.util.List;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        Commun commun = context.getBean("commun", Commun.class);
        List<User> allUser =  commun.getAllUser();
        System.out.println(allUser);
    }
}
