package com.angularapp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.angularapp.dao.ContactRepository;
import com.angularapp.entities.Contact;

@SpringBootApplication
public class AngularTestApplication implements CommandLineRunner {

	@Autowired
	private ContactRepository contactRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AngularTestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		contactRepository.save(new Contact("Maarouf", "Youness", dateFormat.parse("21/07/1993"), "maarouuf_younes@hotmail.fr", "0628882147","D:/images/moi.jpg"));
		*/
		
	}
}
