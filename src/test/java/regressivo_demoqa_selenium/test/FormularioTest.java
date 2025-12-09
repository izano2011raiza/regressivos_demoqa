package regressivo_demoqa_selenium.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import regressivo_demoqa_selenium.elementos.Elementos;
import regressivo_demoqa_selenium.page.ElementosPage;
import regressivo_demoqa_selenium.page.HomePage;
import regressivo_demoqa_selenium.runner.Executa;

public class FormularioTest {

	HomePage home = new HomePage();
	ElementosPage elPage = new ElementosPage();
	Elementos el = new Elementos();

	@BeforeEach
	public void iniciar() {
		Executa.abrirNavegador();
		home.acessarSubMenu("Elements", "Text Box");
	}

	@AfterEach
	public void finalizar() {
		Executa.fecharNavegador();
	}

	@Test
	public void cadastrarComDadosEmBranco() {
		elPage.preencherParcialmenteFormulario("", "", "", "");
		elPage.validarFormularioParcial("", "", "", "");
	}

	@Test
	public void cadastrarSemPreencherName() {
		elPage.preencherParcialmenteFormulario("", "isanotest@gmail.com", "test1", "test2");
		elPage.validarFormularioParcial("", "isanotest@gmail.com", "test1", "test2");
	}

	@Test
	public void cadastrarSemPreencherEmail() {
		elPage.preencherParcialmenteFormulario("isanotest", "", "test1", "test2");
		elPage.validarFormularioParcial("isanotest", "", "test1", "test2");
	}

	@Test
	public void cadastrarSemPreencherCaddress() {
		elPage.preencherParcialmenteFormulario("isanotest", "isanotest@gmail.com", "", "test2");
		elPage.validarFormularioParcial("isanotest", "isanotest@gmail.com", "", "test2");
	}

	@Test
	public void cadastrarSemPreencherPaddress() {
		elPage.preencherParcialmenteFormulario("isanotest", "isanotest@gmail.com", "test", "");
		elPage.validarFormularioParcial("isanotest", "isanotest@gmail.com", "test", "");
	}

	@Test
	public void CadastroUsuarioSucesso() {
		elPage.preencherFormulario("Izano", "isanotest@gmail.com", "test1", "test2");
		elPage.validarFormulario("Izano", "isanotest@gmail.com", "test1", "test2");

	}
}
