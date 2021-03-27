package br.furb.bcc.bancosangue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BancoSangueApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(BancoSangueApplication.class, args);
		} catch (Throwable e){
			e.printStackTrace();
		}
	}

}