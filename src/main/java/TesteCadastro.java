import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCadastro {

	@Test
	public void deveCadastrarComSucesso() {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/micha/Downloads/campo_treinamento/componentes.html");

		driver.findElement(By.id("elementosForm:nome")).sendKeys("jefferson");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("rodrigues");
		driver.findElement(By.id("elementosForm:sexo")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		// estes comandos somente estão puxando o select do web elements (deve interagir
		// com combo) da classe teste campo treinamento
		new Select(driver.findElement(By.id("elementosForm:escolaridade"))).selectByVisibleText("2o grau completo");

		new Select(driver.findElement(By.id("elementosForm:esportes"))).selectByVisibleText("Natacao");
		//
		driver.findElement(By.id("elementosForm:cadastrar")).click();

		Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado"));
		Assert.assertTrue(driver.findElement(By.id("descNome")).getText().endsWith("jefferson"));
		Assert.assertEquals("Sobrenome: rodrigues", driver.findElement(By.id("descSobrenome")).getText());
		Assert.assertEquals("Sexo: Masculino", driver.findElement(By.id("descSexo")).getText());
		Assert.assertEquals("Comida: Pizza", driver.findElement(By.id("descComida")).getText());
		Assert.assertEquals("Escolaridade: 2graucomp", driver.findElement(By.id("descEscolaridade")).getText());
		Assert.assertEquals("Esportes: Natacao", driver.findElement(By.id("descEsportes")).getText());

		driver.quit();
	}

	@Test
	public void deveValidarNomeObrigatorio() {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/micha/Downloads/campo_treinamento/componentes.html");

		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Nome eh obrigatorio", alert.getText());
		driver.quit();

	}

	@Test
	public void deveValidarSobrenomeObrigatorio() {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/micha/Downloads/campo_treinamento/componentes.html");

		driver.findElement(By.id("elementosForm:nome")).sendKeys("nome qualquer");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Sobrenome eh obrigatorio", alert.getText());
		driver.quit();

	}

	@Test
	public void deveValidarSexoObrigatorio() {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/micha/Downloads/campo_treinamento/componentes.html");

		driver.findElement(By.id("elementosForm:nome")).sendKeys("nome qualquer");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("sobreome qualquer");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Sexo eh obrigatorio", alert.getText());
		driver.quit();

	}

	@Test
	public void deveValidarComidaVegetariana() {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/micha/Downloads/campo_treinamento/componentes.html");

		driver.findElement(By.id("elementosForm:nome")).sendKeys("nome qualquer");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("sobreome qualquer");
		driver.findElement(By.id("elementosForm:sexo:1")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
		driver.quit();

	}

	@Test
	public void deveValidarEsportistaIndeciso() {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/micha/Downloads/campo_treinamento/componentes.html");

		driver.findElement(By.id("elementosForm:nome")).sendKeys("nome qualquer");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("sobreome qualquer");
		driver.findElement(By.id("elementosForm:sexo:1")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		Select combo = new Select(driver.findElement(By.id("elementosForm:esportes")));
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("O que eh esporte?");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Voce faz esporte ou nao?", alert.getText());
		driver.quit();

	}

}
