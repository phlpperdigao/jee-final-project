package com.javaee.philipe.projetofinalphilipe.email;

public class EmailSender {
	public final static String ASSUNTO_SUCESSO_VENDA = "Acao vendida.";
	public final static String ASSUNTO_SUCESSO_AQUISICAO = "Acao adquirida.";
	
	public final static String CORPO_SUCESSO_VENDA = "Sua acao foi vendida com sucesso.";
	public final static String CORPO_SUCESSO_AQUISICAO = "Sua acao foi adquirida com sucesso.";
	
	public static void send(String toEmail,String subject, String body) {
		final String fromEmail= "@gmail.com";
		final String password = "";
		
		EmailConfig config = new EmailConfig();
		config.sendEmail(fromEmail,password,toEmail,subject,body);
	}
}