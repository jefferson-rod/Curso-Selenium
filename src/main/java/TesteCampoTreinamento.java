import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {
	
	@Test
	public void testeTextField () {
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///C:/Users/micha/Downloads/campo_treinamento/componentes.html");
       
        driver.findElement(By.id("elementosForm:nome")).sendKeys("teste de escrita");
        Assert.assertEquals("teste de escrita",driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
        driver.quit();
        
	}
        @Test
    	public void deveInteragirComTextArea (){
    		
        	 WebDriver driver = new ChromeDriver();
             driver.manage().window().maximize();
             driver.get("file:///C:/Users/micha/Downloads/campo_treinamento/componentes.html");
             
             driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("teste");
             Assert.assertEquals("teste",  driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
             
             driver.quit();
        
        }
        
        
        @Test
    	public void DeveInteragirComRadioButton () {
    		
    		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("file:///C:/Users/micha/Downloads/campo_treinamento/componentes.html");
        
            driver.findElement(By.id("elementosForm:sexo:0")).click();
            Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
            driver.quit();
	}
        
        @Test
    	public void DeveInteragirComCheckBox () {
    		
    		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("file:///C:/Users/micha/Downloads/campo_treinamento/componentes.html");
        
            driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
            Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
            driver.quit();
	}
        
        @Test
    	public void DeveInteragirComCombo () {
    		
    		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("file:///C:/Users/micha/Downloads/campo_treinamento/componentes.html");
        
            WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
            Select combo = new Select(element);
            //combo.selectByIndex(3);
            //combo.selectByValue("Superior");
            combo.selectByVisibleText("Mestrado");
            
            Assert.assertEquals("Mestrado", combo.getFirstSelectedOption().getText());
            driver.quit();
	}
        
        @Test
    	public void DeveVerificarValoresCombo () {
    		
    		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("file:///C:/Users/micha/Downloads/campo_treinamento/componentes.html");
        
            WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
            Select combo = new Select(element);
            //O comando abaixo me retorna uma lista de web elements com todas a opções disponiveis para aquele select
            List <WebElement> options = combo.getOptions();
            Assert.assertEquals(8, options.size());
            
            boolean encontrou = false;
            		for(WebElement option: options) {
            			if(option.getText().equals("Mestrado")) {
            				
            				encontrou = true;
            				break;
            			}
            		}
            		Assert.assertTrue(encontrou);
        
        }
        
        
        @Test
    	public void DeveVerificarValoresComboMultiplos () {
    		
    		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("file:///C:/Users/micha/Downloads/campo_treinamento/componentes.html");
        
            WebElement element = driver.findElement(By.id("elementosForm:esportes"));
            Select combo = new Select(element);
            combo.selectByVisibleText("Natacao");
            combo.selectByVisibleText("Corrida");
            combo.selectByVisibleText("O que eh esporte?");
            
            //vamos a verificação da lista
            //Aqui ele da a assertiva referente a quantidade de opções escolhidas, no caso foram 3
            
            List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
            Assert.assertEquals(3, allSelectedOptions.size());
            
            //Caso seja preciso desselecionar algum item ja selecionado use o comando a seguir
            
            combo.deselectByVisibleText("Corrida");
            driver.quit();
        
        }
        
        @Test
    	public void DeveInteragirComBotao () {
    		
    		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("file:///C:/Users/micha/Downloads/campo_treinamento/componentes.html");
            
        //Quando eu instancio o elemento botao eu estou dizendo que onde tiber escrito botão ele ira rodar o comando webelemet
            
            WebElement botao = driver.findElement(By.id("buttonSimple"));
            botao.click();
            Assert.assertEquals("Obrigado!",botao.getAttribute("value"));
            driver.quit();

        } 
        
        
        @Test
        
        //O @ignore serve para ignorar um teste caso necessite de alguma correçõa e voce deixe para corrigir depois
       // @Ignore
    	public void DeveInteragirComLinks() {
    		
    		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("file:///C:/Users/micha/Downloads/campo_treinamento/componentes.html");
            
            driver.findElement(By.linkText("Voltar")).click();
            Assert.assertEquals("Voltou!",driver.findElement(By.id("resultado")).getText());
            driver.quit();
        }
        
        @Test
    	public void DeveBuscarTextosNaPagina() {
    		
    		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("file:///C:/Users/micha/Downloads/campo_treinamento/componentes.html");
         
            //aqui eu pergundo ao sistema se no campo body que é a pagina inteira contém em algum lugar a string inserida
            
            //Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo de Treinamento"));
            Assert.assertEquals("Campo de Treinamento",driver.findElement(By.tagName("h3")).getText());
            Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",driver.findElement(By.className("facilAchar")).getText());
            driver.quit();
            
            
        }
        
}


