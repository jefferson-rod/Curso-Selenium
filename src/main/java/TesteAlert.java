import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteAlert {

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
	public void deveInteragirComAlertSimples() {

		driver.findElement(By.id("alert")).click();

		// Ao executar este comando aparece a mensagem de alerta na tela porém ela se
		// encontra externa então com o comqndo a seguir voce orienta o selenium a mudar
		// o foco da busca pelo item do alerta

		driver.switchTo().alert();
		Alert alert = driver.switchTo().alert();
		String texto = alert.getText();
		Assert.assertEquals("Alert Simples", texto);
		alert.accept();
		driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);

	}

	@Test
	public void deveInteragirComAlertConfirm() {

		driver.findElement(By.id("confirm")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", alert.getText());
		alert.accept();
		Assert.assertEquals("Confirmado", alert.getText());
		alert.accept();

		// O bloco acima é o alerta de confirma e o abaixo, o aleta de negado

		driver.findElement(By.id("confirm")).click();
		alert = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", alert.getText());
		alert.dismiss();
		Assert.assertEquals("Negado", alert.getText());
		alert.dismiss();
	}

	@Test
	public void deveInteragirComAlertPrompt() {

		driver.findElement(By.id("prompt")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Digite um numero", alert.getText());
		alert.sendKeys("12");
		alert.accept();
		Assert.assertEquals("Era 12?", alert.getText());
		alert.accept();
		Assert.assertEquals(":D", alert.getText());
		alert.accept();

	}

}
