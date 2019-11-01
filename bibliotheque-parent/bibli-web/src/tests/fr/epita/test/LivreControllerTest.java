package fr.epita.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import fr.epita.controller.LivreController;
import fr.epita.entity.Livre;

//@RunWith(SpringJ)
//@ContextConfiguration(classes)
public class LivreControllerTest {
	
	LivreController controller;
	Livre livre;

	@Before
	public void setUp() throws Exception {
		controller = new LivreController();
		livre = new Livre();
		livre.setTitre("Le livre");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		controller.enregistrerLivre(livre);
	}

}
