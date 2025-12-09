package regressivo_demoqa_selenium.page;

import regressivo_demoqa_selenium.metodos.Metodos;

public class HomePage {
	public void acessarSubMenu(String menu, String subMenu) {
		Metodos.scroll(300);
		Metodos.clicarPorTexto("h5", menu);
		Metodos.clicarPorTexto("span", subMenu);

	}
}
