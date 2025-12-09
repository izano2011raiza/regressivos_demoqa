package regressivo_demoqa_selenium.page;

import org.openqa.selenium.By;
import regressivo_demoqa_selenium.elementos.Elementos;
import regressivo_demoqa_selenium.metodos.Metodos;

public class ElementosPage {

	Elementos el = new Elementos();

	public By name = By.xpath("//p[@id='name']");
	public By email = By.xpath("//p[@id='email']");
	public By cAddress = By.xpath("//p[@id='currentAddress']");
	public By pAddress = By.xpath("//p[@id='permanentAddress']");

	public void preencherFormulario(String userName, String email, String cAddress, String pAddress) {
		Metodos.preencher(el.userName, userName);
		Metodos.preencher(el.email, email);
		Metodos.preencher(el.cAddress, cAddress);
		Metodos.preencher(el.pAddress, pAddress);
		Metodos.scroll(400);
		Metodos.clique(el.btnSubmit);
	}

	public void validarFormulario(String userName, String email, String cAddress, String pAddress) {
		Metodos.validarTexto(this.name, "Name:" + userName);
		Metodos.validarTexto(this.email, "Email:" + email);
		Metodos.validarTexto(this.cAddress, "Current Address :" + cAddress);
		Metodos.validarTexto(this.pAddress, "Permananet Address :" + pAddress);
	}

	public void validarCampo(By locator, String valor, String label) {
		if (valor == null || valor.isEmpty()) {
			Metodos.validarElementoNaoVisivel(locator, "Campo " + label + " não deveria aparecer!");
		} else {
			Metodos.validarTextoFlexivel(locator, label + ":" + valor, "Campo " + label + " incorreto!");
		}
	}

	public void preencherParcialmenteFormulario(String userName, String email, String cAddress, String pAddress) {
		if (userName != null && !userName.isEmpty()) {
			Metodos.preencher(el.userName, userName);
		}
		if (email != null && !email.isEmpty()) {
			Metodos.preencher(el.email, email);
		}
		if (cAddress != null && !cAddress.isEmpty()) {
			Metodos.preencher(el.cAddress, cAddress);
		}
		if (pAddress != null && !pAddress.isEmpty()) {
			Metodos.preencher(el.pAddress, pAddress);
		}
		Metodos.scroll(400);
		Metodos.clique(el.btnSubmit);
	}

	public void validarFormularioParcial(String userName, String email, String cAddress, String pAddress) {
		validarCampo(this.name, userName, "Name");
		validarCampo(this.email, email, "Email");
		validarCampo(this.cAddress, cAddress, "Current Address ");
		validarCampo(this.pAddress, pAddress, "Permananet Address ");
	}

}
