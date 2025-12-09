package regressivo_demoqa_selenium.runner;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import regressivo_demoqa_selenium.drivers.Drivers;

public class Executa extends Drivers {

	private static String navegador = "Edge";

	public static void abrirNavegador() {
		try {
			if (navegador.equalsIgnoreCase("Edge")) {
				driver = new EdgeDriver();
			} else if (navegador.equalsIgnoreCase("Chrome")) {
				driver = new ChromeDriver();
			}
			driver.manage().window().maximize();
			driver.get("https://demoqa.com/");
		} catch (Exception e) {
			System.out.println("Navegador inválido " + e.getCause());
		}

	}

	public static void fecharNavegador() {
		driver.quit();
	}
}
