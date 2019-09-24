package pvermillion.springtutorial.dependencyinjectiondemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import pvermillion.springtutorial.dependencyinjectiondemo.controllers.ConstructorInjectedController;
import pvermillion.springtutorial.dependencyinjectiondemo.controllers.GetterInjectedController;
import pvermillion.springtutorial.dependencyinjectiondemo.controllers.MyController;
import pvermillion.springtutorial.dependencyinjectiondemo.controllers.PropertyInjectedController;
import pvermillion.springtutorial.dependencyinjectiondemo.examplebeans.FakeDataSource;

@SpringBootApplication
public class DependencyInjectionDemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DependencyInjectionDemoApplication.class, args);

		MyController controller = (MyController) ctx.getBean("myController");

		FakeDataSource fakeDataSource = (FakeDataSource) ctx.getBean(FakeDataSource.class);

		System.out.println(fakeDataSource.getUser());
	}

}
