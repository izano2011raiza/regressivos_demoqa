package regressivo_demoqa_selenium.metodos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import regressivo_demoqa_selenium.drivers.Drivers;

public class Metodos extends Drivers {

	public static void clicar(By locator) {
		driver.findElement(locator).click();
	}

	public static void preencher(By locator, String texto) {
		driver.findElement(locator).sendKeys(texto);
	}

	public static void limparCampo(By locator) {
		driver.findElement(locator).clear();
	}

	public static void submit(By locator) {
		driver.findElement(locator).submit();
	}

	public static void validarTexto(By locator, String textoEsperado) {
		String textoCapturado = driver.findElement(locator).getText();
		assertEquals(textoCapturado, textoEsperado);
	}

	public static void scroll(int px) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + px + ")", "Rolando a tela para baixo");
	}

	public static void clicarPorTexto(String atributo, String texto) {
		driver.findElement(By.xpath("//" + atributo + "[text()='" + texto + "']")).click();
	}

	public static void aguardarElementoVisivel(By locator, int segundos) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4000));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public static void validarElementoNaoVisivel(By locator, String mensagemErro) {
		try {
			WebElement elemento = driver.findElement(locator);

			Assertions.assertFalse(elemento.isDisplayed(), mensagemErro);
		} catch (NoSuchElementException e) {

			Assertions.assertTrue(true, mensagemErro);
		}
	}

	public static void validarTextoFlexivel(By locator, String textoEsperado, String mensagemErro) {
		try {
			WebElement elemento = driver.findElement(locator);
			String textoAtual = elemento.getText().trim().toLowerCase();
			Assertions.assertEquals(textoEsperado.trim().toLowerCase(), textoAtual, mensagemErro);
		} catch (NoSuchElementException e) {
			Assertions.fail(mensagemErro + "Elemento não encontrado no DOM.");
		}
	}

	public static void clique(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			WebElement elemento = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elemento);

			wait.until(ExpectedConditions.elementToBeClickable(locator));

			elemento.click();

		} catch (ElementClickInterceptedException e) {

			WebElement elemento = driver.findElement(locator);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", elemento);
			System.out.println("Clique via JS usado como fallback para " + locator.toString());
		} catch (Exception e) {
			Assertions.fail("Falha ao clicar no elemento: " + locator.toString() + " → " + e.getMessage());
		}
	}

	public static void MensagemDeValidacao(By locator, String trechoEsperado) {
		try {
			WebElement elemento = driver.findElement(locator);
			String mensagem = elemento.getAttribute("validationMessage");

			Assertions.assertTrue(mensagem.toLowerCase().contains(trechoEsperado.toLowerCase()),
					"Mensagem de validação não corresponde. Esperado conter: \"" + trechoEsperado + "\" mas foi: \""
							+ mensagem + "\"");
		} catch (NoSuchElementException e) {
			Assertions.fail("Elemento não encontrado para validação: " + locator.toString());
		}
	}
}
