package br.gov.sp.centropaulasouza.biblioteca.utils.mail;

import br.gov.sp.centropaulasouza.biblioteca.model.Pessoa;
import br.gov.sp.centropaulasouza.biblioteca.utils.Context;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

/**
 *
 * @author hideki
 */
public class SimpleRegistrationService {

	private JavaMailSender mailSender;
	private VelocityEngine velocityEngine;

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}

	public void register(Pessoa pessoa) {
		String registrationConfirmation ="template/registration-confirmation.vm";
		sendEmail(pessoa, registrationConfirmation, "Confirmação de cadastro");
	}
	
	public void esqueciSenha(Pessoa pessoa){
		String esqueciSenha = "template/esqueci-senha.vm";
		sendEmail(pessoa, esqueciSenha, "Confirmação de troca de senha");
	}

	private void sendEmail(final Pessoa pessoa, final String templatePath, final String subject) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(pessoa.getEmail());
				message.setSubject(subject);
				message.setFrom("bibliotecafatec@outlook.com");
				Map<String, Object> model = new HashMap<>();
				model.put("pessoa", pessoa);
				model.put("context", Context.getContextPath());
				String text = VelocityEngineUtils.mergeTemplateIntoString(
						velocityEngine, templatePath,"utf-8", model);
				message.setText(text, true);
			}
		};
		this.mailSender.send(preparator);
	}
}
