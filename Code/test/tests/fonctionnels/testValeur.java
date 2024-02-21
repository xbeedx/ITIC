package tests.fonctionnels;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testEtat.Conteneur;

class testValeur {
	
	private Conteneur conteneur;
	private Object C;
	private Object O;
	
    @BeforeAll
    static void setUpBeforeClass() {
        // Initialize resources shared by all tests in this class (if any)
    }

    @AfterAll
    static void tearDownAfterClass() {
        // Release resources used by all tests in this class (if any)
    }
    
    @BeforeEach
    void setUp() {
        // Initialize resources before each test
        conteneur = null; // Reset the conteneur before each test
        C = null; // Reset the key before each test
        O = null; // Reset the value before each test
    }

    @AfterEach
    void tearDown() {
        // Release resources after each test
        conteneur = null; // Ensure that the conteneur is null after each test
        C = null; // Ensure that the key is null after each test
        O = null; // Ensure that the value is null after each test
    }

    @Test
    void valeurTest1() {
    	
    	Assertions.assertThrows(Exception.class, () -> {
    		// Partition2_1 - This.object is empty
        	
        	
        	// Partition1_3 - Object C is null
        	C = null;
        	// Partition1_1 - Object C absente 
        	
        	conteneur.valeur(C);
    	});
    }
    
    @Test
    void valeurTest2() {
    	
    	Assertions.assertThrows(Exception.class, () -> {
    		// Partition2_1 - This.object is empty
        	
        	// Partition1_4 - Object C not null
        	C = 5;
        	// Partition1_1 - Object C absente 
        	
        	conteneur.valeur(C);
    	});
    }
    
    @Test
    void valeurTest3() {
    	
    	Assertions.assertThrows(testEtat.ErreurConteneur.class, () -> {
    		// Partition2.2 - This.object is not empty
        	conteneur = new Conteneur(4);
        	
        	// Partition1_3 - Object C is null
        	
        	// Partition1_1 - Object C absente 
        	
        	conteneur.valeur(C);
    	});
    }
    
    
    @Test
    void valeurTest4() {
    	
    	Assertions.assertThrows(testEtat.ErreurConteneur.class, () -> {
    		// Partition2.2 - This.object is not empty
        	conteneur = new Conteneur(4);
        	
        	// Partition1_4 - Object C not null
        	C = 2;
        	// Partition1_1 - Object C absente 
        	
        	conteneur.valeur(C);
    	});
    }
    
    @Test
    void valeurTest5() {
    	
    	Assertions.assertThrows(Exception.class, () -> {
    		// Partition2.1 - This.object is empty
        	
        	// Partition1_3 - Object C is null
        	
        	// Partition1_2 - Object C presente 
        	O=2;
        	conteneur.ajouter(C,O);
        	
        	conteneur.valeur(C);
    	});
    }
    
    @Test
    void valeurTest6() {
    	
    	Assertions.assertThrows(Exception.class, () -> {
    		// Partition2.1 - This.object is empty
        	
        	// Partition1_4 - Object C not null
        	C = 2;
        	// Partition1_2 - Object C presente 
        	O=5;
        	conteneur.ajouter(C,O);
        	conteneur.valeur(C);
    	});
    }
    
    @Test
    void valeurTest7() {
    	
    	Assertions.assertThrows(Exception.class, () -> {
    		// Partition2.2 - This.object is not empty
        	conteneur = new Conteneur(2);
        	
        	// Partition1_3 - Object C is null
        	
        	// Partition1_2 - Object C presente 
        	O=5;
        	conteneur.ajouter(C,O);
        	
        	System.out.print(conteneur.valeur(C));
    	});
    }
    
    @Test
    void valeurTest8() {
    	
    	Assertions.assertAll(
    		    () -> Assertions.assertDoesNotThrow(() -> {
    	    		// Partition2.2 - This.object is not empty
    		    	conteneur = new Conteneur(2);
    	        	
    	        	// Partition1_4 - Object C not null
    	        	C = 2;
    	        	// Partition1_2 - Object C presente 
    	        	O=5;
    	        	conteneur.ajouter(C,O);
    	    	}),
    		    () -> Assertions.assertEquals(O, conteneur.valeur(C))
    		);
    }
    
    
}
