package spring.example.org;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.ResponseEntity;
import spring.Commun;
import spring.config.MyConfig;
import spring.models.User;

import java.io.IOException;
import java.util.List;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        Commun commun = context.getBean("commun", Commun.class);
        String allUser =  commun.getAllUser();
        //System.out.println(allUser);
User user = new User();
        //commun.addUser(allUser, user);
        //String allUser1 =  commun.getAllUser();
        //commun.updateUser(allUser);
        System.out.println(commun.addUser(allUser, user) + commun.updateUser(allUser) + commun.deleteUser(allUser, 3L));
    }
}
