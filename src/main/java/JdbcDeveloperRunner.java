import dao.jdbc.JdbcTemplateDeveloperDaoImpl;
import model.Developer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.util.List;

/**
 * Created by Dzmitry Dziachenka on 10/26/2018
 */
public class JdbcDeveloperRunner {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbctemplate-developer-config.xml");

        JdbcTemplateDeveloperDaoImpl jdbcTemplateDeveloperDao =
                (JdbcTemplateDeveloperDaoImpl) context.getBean("jdbcTemplateDeveloperDao");

        System.out.println("========Creating new records to DB========");
        jdbcTemplateDeveloperDao.createDeveloper("Proselyte", "Java Developer", 3);
        jdbcTemplateDeveloperDao.createDeveloper("Petr", "C++ Developer", 2);
        jdbcTemplateDeveloperDao.createDeveloper("DesignerAsya", "UI Developer", 1);

        System.out.println("========Developers List========");
        List<Developer> developers = jdbcTemplateDeveloperDao.listDevelopers();
        for (Developer developer : developers) {
            System.out.println(developer);
        }

        System.out.println("========Some changes to DB========");
        jdbcTemplateDeveloperDao.updateDeveloper(3, "DesignerAsya", "UI Developer", 2);
        jdbcTemplateDeveloperDao.removeDeveloper(2);

        System.out.println("========Final Developers List========");
        List<Developer> finalDevelopers = jdbcTemplateDeveloperDao.listDevelopers();
        for (Developer developer : finalDevelopers) {
            System.out.println(developer);
        }
    }
}

