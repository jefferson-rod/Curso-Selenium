import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteFrames {

	@Test
	public void deveInteragirComFramesEJanelas() {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/micha/Downloads/campo_treinamento/componentes.html");

		driver.switchTo().frame("frame1");
		driver.findElement(By.id("frameButton")).click();
		Alert alert = driver.switchTo().alert();
		String msg = alert.getText();
		Assert.assertEquals("Frame OK!", msg);
		alert.accept();

		// Logo no inicio por se tratar de um frame usa-se o switch to para mudar o foco
		// da pagina para retornar o foco devido a acertiva utiliza-se o comando abaixo
		// para retornar o foco para pagina principal
		driver.switchTo().defaultContent();
		//
		driver.findElement(By.id("elementosForm:nome")).sendKeys(msg);

		driver.quit();

	}

	@Test
	public void deveInteragirComJanelas() {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/micha/Downloads/campo_treinamento/componentes.html");

		driver.findElement(By.id("buttonPopUpEasy")).click();
		driver.switchTo().window("Popup");
		driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");
		driver.close();

		// agora como o foco da pagina esta na janela popup basta repetir o comando com
		// o nome da janela ou sem nome que ele retorna a pagina que não tem titulo
		driver.switchTo().window("");
		driver.findElement(By.tagName("textarea")).sendKeys("E agora?");
		driver.quit();

	}

	@Test
	public void deveInteragirComJanelasSemTitulo() {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/micha/Downloads/campo_treinamento/componentes.html");

		driver.findElement(By.id("buttonPopUpHard")).click();
		// O windowHandler é um comando que tras as coleçoes de janelas que o sistema
		// gerencia,no caso em que estamos 2;
		// Os comandos abaixo retornam o identificador dessas janelas então o primeiro
		// identifica a principal em que estamos e o segundo as demais janelas, como so
		// temos 2 a outra será da popup sem titulo
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getWindowHandles());

		// O comando abaixo serve para buscar o identificador da janela, o comando array
		// busca um objeto e é indexado por 0, como eu quero o segundo a numeração é 1
		// O mesmo comando causa um erro no window por isso temos que instanciar o
		// comando "string";

		driver.switchTo().window((String) (driver.getWindowHandles().toArray()[1]));
		driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");
		driver.switchTo().window((String) (driver.getWindowHandles().toArray()[0]));
		driver.findElement(By.tagName("textarea")).sendKeys("E agora?");

		driver.quit();

		// O TESTE FAZ EXATAMENTE O QUE O ACIMA FAZ, A UNICA DIFERENÇA É QUE ESTE NÃO
		// TEM IDENTIFICADOR NA MENSAGEM POPUP//
	}

}
