package timeline.test.controllers;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ModelAndView;

import timeline.controllers.LoginController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class LoginControllerTests {

	@Test
	public void autenticacion() throws Exception {
		LoginController controller = new LoginController();
		ModelAndView modelAndView = controller.autenticacion("leandroandres1@gmail.com","123456");
		Assert.assertEquals("bienvenidoagente", modelAndView.getViewName());
		Assert.assertEquals(9, modelAndView.getModel().get("novedades"));

	}

	@Configuration
	public static class TestConfiguration {
		@Bean
		public LoginController LoginController() {
			return new LoginController();
		}

	}
}