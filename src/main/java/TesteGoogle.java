import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteGoogle {

	private WebDriver driver;

	@Before
	public void inicializa() {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/micha/Downloads/campo_treinamento/componentes.html");

	}

	@After
	public void finaliza() {

		driver.quit();

	}

	@Test
	public void teste() {

		driver.get("http://www.google.com");
		Assert.assertEquals("Google", driver.getTitle());

	}

}
