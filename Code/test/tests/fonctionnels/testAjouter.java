package tests.fonctionnels;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testEtat.Conteneur;
import testEtat.ErreurConteneur;

class testAjouter {
	
	static private Conteneur conteneur;
	static private Object C;
	static private Object O;
	
    @BeforeAll
    static void setUpBeforeClass() {
        // Initialize resources shared by all tests in this class (if any)
    }

    @AfterAll
    static void tearDownAfterClass() {
    	 conteneur = null; 
         C = null;
         O = null;
    }
    
    @BeforeEach
    void setUp() {
        // Initialize resources before each test
        try {
			conteneur= new Conteneur(2); // Reset the conteneur before each test
		} catch (ErreurConteneur e) {
			e.printStackTrace();
		}; 
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
    void ajouterTest1() {
    	
    	Assertions.assertThrows(Exception.class, () -> {
    		// Partition1_3 - Object C = null
    		// Partition2_3 - Object O = null
    		// Partition1_4 - Object C already in container
    		// Partition2_4	- Object O already in container
    		conteneur.ajouter(C,O);
    		// Partition3_2	- Container full
    		conteneur.ajouter(0,0);
    		//
        	conteneur.ajouter(C,O);
    	});
    }
    
    @Test
    void ajouterTest2() {
        Assertions.assertThrows(Exception.class, () -> {
            // Partition1_1 - Object C != null
        	C=2;
            // Partition2_3 - Object O = null
            // Partition1_4 - Object C already in container
            // Partition2_4 - Object O already in container
        	conteneur.ajouter(C,O);
        	// Partition3_2 - Container full
        	conteneur.ajouter(0,0);
        	//
        	conteneur.ajouter(C,O);
        });
    }
    
    @Test
    void ajouterTest3() {
        Assertions.assertThrows(Exception.class, () -> {
            // Partition1_3 - Object C = null
            // Partition2_1 - Object O != null
        	O=5;
            // Partition1_4 - Object C already in container
            // Partition2_4 - Object O already in container
        	conteneur.ajouter(C,O);
        	// Partition3_2 - Container full
        	conteneur.ajouter(0,0);
        	//
        	conteneur.ajouter(C,O);
        });
    }
    
    @Test
    void ajouterTest4() {
        Assertions.assertThrows(testEtat.DebordementConteneur.class, () -> {
            // Partition1_1 - Object C != null
        	C=2;
            // Partition2_1 - Object O != null
        	O=5;
            // Partition1_4 - Object C already in container
            // Partition2_4 - Object O already in container
        	conteneur.ajouter(C,O);
        	// Partition3_2 - Container full
        	conteneur.ajouter(0,0);
        	//
        	conteneur.ajouter(C,O);
        });
    }
    
    @Test
    void ajouterTest5() {
        Assertions.assertThrows(Exception.class, () -> {
            // Partition1_3 - Object C = null
            // Partition2_3 - Object O = null
            // Partition1_4 - Object C already in container
            // Partition2_4 - Object O already in container
        	conteneur.ajouter(C,O);
        	// Partition3_1 - Container not full
        	//
        	conteneur.ajouter(C,O);
        });
    }
    
    @Test
    void ajouterTest6() {
        Assertions.assertThrows(Exception.class, () -> {
            // Partition1_1 - Object C != null
        	C=2;
            // Partition2_3 - Object O = null
            // Partition1_4 - Object C already in container
            // Partition2_4 - Object O already in container
        	conteneur.ajouter(C,O);
        	// Partition3_1 - Container not full
            //
        	conteneur.ajouter(C,O);
        });
    }
    
    @Test
    void ajouterTest7() {
        Assertions.assertThrows(Exception.class, () -> {
            // Partition1_3 - Object C = null
            // Partition2_1 - Object O != null
        	O=5;
            // Partition1_4 - Object C already in container
            // Partition2_4 - Object O already in container
        	conteneur.ajouter(C,O);
        	// Partition3_1 - Container not full
        	//
        	conteneur.ajouter(C,O);
        });
    }
    
    @Test
    void ajouterTest8() {
    	Assertions.assertAll(
    		    () -> Assertions.assertDoesNotThrow(() -> {
    	            // Partition1_1 - Object C != null
    	        	C=2;
    	            // Partition2_1 - Object O != null
    	        	O=5;
    	            // Partition1_4 - Object C already in container
    	            // Partition2_4 - Object O already in container
    	        	conteneur.ajouter(C,O);
    	        	// Partition3_1 - Container not full
    	        	//
    	        	O=6;
    	        	conteneur.ajouter(C,O);
    	        }),
    		    () -> Assertions.assertEquals(O, conteneur.valeur(C)),
    		    () ->  Assertions.assertEquals(2, conteneur.taille())
    		);
    }
    
    @Test
    void ajouterTest9() {

        Assertions.assertThrows(Exception.class, () -> {
            // Partition1_3 - Object C = null
            // Partition2_3 - Object O = null
            // Partition1_4 - Object C not in container
            // Partition2_4 - Object O already in container
        	conteneur.ajouter(-1,O);
        	// Partition3_2 - Container full
        	//
        	conteneur.ajouter(C,O);
        });
    }

    @Test
    void ajouterTest10() {
        Assertions.assertThrows(Exception.class, () -> {
            // Partition1_1 - Object C != null
        	C=2;
            // Partition2_3 - Object O = null
            // Partition1_4 - Object C not in container
            // Partition2_4 - Object O already in container
        	conteneur.ajouter(-1,O);
        	// Partition3_2 - Container full
        	conteneur.ajouter(0,0);
        	//
        	conteneur.ajouter(C,O);
        });
    }
    
    @Test
    void ajouterTest11() {
        Assertions.assertThrows(Exception.class, () -> {
            // Partition1_3 - Object C = null
            // Partition2_1 - Object O != null
        	O=5;
            // Partition1_4 - Object C not in container
            // Partition2_4 - Object O already in container
        	conteneur.ajouter(-1,O);
        	// Partition3_2 - Container full
        	conteneur.ajouter(0,0);
        	//
        	conteneur.ajouter(C,O);
        });
    }
    
    @Test
    void ajouterTest12() {
        Assertions.assertThrows(testEtat.DebordementConteneur.class, () -> {
            // Partition1_1 - Object C != null
        	C=2;
            // Partition2_1 - Object O != null
        	O=5;
            // Partition1_4 - Object C not in container
            // Partition2_4 - Object O already in container
        	conteneur.ajouter(-1,O);
        	// Partition3_2 - Container full
        	conteneur.ajouter(0,0);
        	//
        	conteneur.ajouter(C,O);
        });
    }
    
    @Test
    void ajouterTest13() {
        Assertions.assertThrows(Exception.class,() -> {
            // Partition1_3 - Object C = null
            // Partition2_3 - Object O = null
            // Partition1_4 - Object C not in container
            // Partition2_4 - Object O already in container
        	conteneur.ajouter(-1,O);
        	// Partition3_1 - Container not full
        	//
        	conteneur.ajouter(C,O);
        });
    }
    
    @Test
    void ajouterTest14() {
        Assertions.assertThrows(Exception.class, () -> {
            // Partition1_1 - Object C != null
        	C=2;
            // Partition2_3 - Object O = null
            // Partition1_4 - Object C not in container
            // Partition2_4 - Object O already in container
        	conteneur.ajouter(-1,O);
        	// Partition3_1 - Container not full
        	//
        	conteneur.ajouter(C,O);
        });
    }
    
    @Test
    void ajouterTest15() {
        Assertions.assertThrows(Exception.class, () -> {
            // Partition1_3 - Object C = null
            // Partition2_1 - Object O != null
        	O=5;
            // Partition1_4 - Object C not in container
            // Partition2_4 - Object O already in container
        	conteneur.ajouter(-1,O);
        	// Partition3_1 - Container not full
        	//
        	conteneur.ajouter(C,O);
        });
    }
    
    @Test
    void ajouterTest16() {
    	Assertions.assertAll(
    		    () -> Assertions.assertDoesNotThrow(() -> {
    		    	// Partition1_1 - Object C != null
    		    	C=2;
	                // Partition2_1 - Object O != null
    		    	O=5;
	                // Partition1_4 - Object C not in container
	                // Partition2_4 - Object O already in container
    		    	conteneur.ajouter(-1,O);
    		    	// Partition3_1 - Container not full
    	            //
    	        	conteneur.ajouter(C,O);
    	        }),
    		    () -> Assertions.assertEquals(O, conteneur.valeur(C))
    		);
    }
    
    @Test
    void ajouterTest17() {
        Assertions.assertThrows(Exception.class, () -> {
            // Partition1_3 - Object C = null
            // Partition2_3 - Object O = null
            // Partition1_4 - Object C already in container
            // Partition2_4 - Object O not in container
        	conteneur.ajouter(C,-1);
        	// Partition3_2 - Container full
        	conteneur.ajouter(0,0);
        	//
        	conteneur.ajouter(C,O);
        });
    }
    
    @Test
    void ajouterTest18() {
        Assertions.assertThrows(Exception.class, () -> {
            // Partition1_1 - Object C != null
        	C=2;
            // Partition2_3 - Object O = null
            // Partition1_4 - Object C already in container
            // Partition2_4 - Object O not in container
        	conteneur.ajouter(C,-1);
        	// Partition3_2 - Container full
        	conteneur.ajouter(0,0);
        	//
        	conteneur.ajouter(C,O);
        });
    }

    @Test
    void ajouterTest19() {
        Assertions.assertThrows(Exception.class, () -> {
            // Partition1_3 - Object C = null
            // Partition2_1 - Object O != null
        	O=5;
            // Partition1_4 - Object C already in container
            // Partition2_4 - Object O not in container
        	conteneur.ajouter(C,-1);
        	// Partition3_2 - Container full
        	conteneur.ajouter(0,0);
        	//
        	conteneur.ajouter(C,O);
        });
    }
    
    @Test
    void ajouterTest20() {
        Assertions.assertThrows(testEtat.DebordementConteneur.class, () -> {
            // Partition1_1 - Object C != null
        	C=2;
            // Partition2_1 - Object O != null
        	O=5;
            // Partition1_4 - Object C already in container
            // Partition2_4 - Object O not in container
        	conteneur.ajouter(C,-1);
        	// Partition3_2 - Container full
        	conteneur.ajouter(0,0);
        	//
        	conteneur.ajouter(C,O);
        });
    }
    
    @Test
    void ajouterTest21() {
        Assertions.assertThrows(Exception.class, () -> {
            // Partition1_3 - Object C = null
            // Partition2_3 - Object O = null
            // Partition1_4 - Object C already in container
            // Partition2_4 - Object O not in container
        	conteneur.ajouter(C,-1);
        	// Partition3_1 - Container not full
        	//
        	conteneur.ajouter(C,O);
        });
    }

    @Test
    void ajouterTest22() {
        Assertions.assertThrows(Exception.class, () -> {
            // Partition1_1 - Object C != null
        	C=2;
            // Partition2_3 - Object O = null
            // Partition1_4 - Object C already in container
            // Partition2_4 - Object O not in container
        	conteneur.ajouter(C,-1);
        	// Partition3_1 - Container not full
        	//
        	conteneur.ajouter(C,O);
        });
    }

    @Test
    void ajouterTest23() {
        Assertions.assertThrows(Exception.class, () -> {
            // Partition1_3 - Object C = null
            // Partition2_1 - Object O != null
        	O=5;
        	// Partition1_4 - Object C already in container
            // Partition2_4 - Object O not in container
        	conteneur.ajouter(C,-1);
        	// Partition3_1 - Container not full
        	//
        	conteneur.ajouter(C,O);
        });
    }
    
    @Test
    void ajouterTest24() {
    	Assertions.assertAll(
    		    () -> Assertions.assertDoesNotThrow(() -> {
    		    	// Partition1_1 - Object C != null
    		    	C=2;
    	            // Partition2_1 - Object O != null
    	        	O=5;
    	        	// Partition1_4 - Object C already in container
    	            // Partition2_4 - Object O not in container
    	        	conteneur.ajouter(C,-1);
    	        	// Partition3_1 - Container not full
    	        	//
    	        	conteneur.ajouter(C,O);
    	        }),
    		    () -> Assertions.assertEquals(O, conteneur.valeur(C)),
    		    () ->  Assertions.assertEquals(1, conteneur.taille())
    		);
    }
    
    @Test
    void ajouterTest25() {
        Assertions.assertThrows(Exception.class, () -> {
            // Partition1_3 - Object C = null
            // Partition2_3 - Object O = null
            // Partition1_4 - Object C not in container
            // Partition2_4 - Object O not in container
        	conteneur.ajouter(-1,-1);
        	// Partition3_2 - Container full
        	conteneur.ajouter(0,0);
        	//
        	conteneur.ajouter(C,O);
        });
    }

    @Test
    void ajouterTest26() {
        Assertions.assertThrows(Exception.class, () -> {
            // Partition1_1 - Object C != null
        	C=2;
        	// Partition2_3 - Object O = null
            // Partition1_4 - Object C not in container
            // Partition2_4 - Object O not in container
        	conteneur.ajouter(-1,-1);
        	// Partition3_2 - Container full
        	conteneur.ajouter(0,0);
        	//
        	conteneur.ajouter(C,O);
        });
    }
 
	@Test
    void ajouterTest27() {
        Assertions.assertThrows(Exception.class, () -> {
            // Partition1_3 - Object C = null
            // Partition2_1 - Object O != null
        	O=5;
            // Partition1_4 - Object C not in container
            // Partition2_4 - Object O not in container
        	conteneur.ajouter(-1,-1);
        	// Partition3_2 - Container full
        	conteneur.ajouter(0,0);
        	//
        	conteneur.ajouter(C,O);
        });
    }
	
	@Test
    void ajouterTest28() {
        Assertions.assertThrows(testEtat.DebordementConteneur.class, () -> {
        	// Partition1_1 - Object C != null
        	C=2;
            // Partition2_1 - Object O != null
        	O=5;
            // Partition1_4 - Object C not in container
            // Partition2_4 - Object O not in container
        	conteneur.ajouter(-1,-1);
        	// Partition3_2 - Container full
        	conteneur.ajouter(0,0);
        	//
        	conteneur.ajouter(C,O);
        });
    }
	
	@Test
    void ajouterTest29() {
        Assertions.assertThrows(Exception.class, () -> {
            // Partition1_3 - Object C = null
            // Partition2_3 - Object O = null
            // Partition1_4 - Object C not in container
            // Partition2_4 - Object O not in container
        	conteneur.ajouter(-1,-1);
        	// Partition3_1 - Container not full
        	//
        	conteneur.ajouter(C,O);
        });
    }

    // Test30
    @Test
    void ajouterTest30() {
        Assertions.assertThrows(Exception.class, () -> {
            // Partition1_1 - Object C != null
        	C=2;
        	// Partition2_3 - Object O = null
            // Partition1_4 - Object C not in container
            // Partition2_4 - Object O not in container
        	conteneur.ajouter(-1,-1);
        	// Partition3_1 - Container not full
        	//
        	conteneur.ajouter(C,O);
        });
    }
    
    @Test
    void ajouterTest31() {
        Assertions.assertThrows(Exception.class, () -> {
            // Partition1_3 - Object C = null
            // Partition2_1 - Object O != null
        	O=5;
        	// Partition1_4 - Object C not in container
            // Partition2_4 - Object O not in container
        	conteneur.ajouter(-1,-1);
        	// Partition3_1 - Container not full
        	//
        	conteneur.ajouter(C,O);
        });
    }
    
    @Test
    void ajouterTest32() {
    	Assertions.assertAll(
    		    () -> Assertions.assertDoesNotThrow(() -> {
    		    	// Partition1_1 - Object C != null
    		    	C=2;
    		    	// Partition2_1 - Object O != null
    	        	O=5;
    	        	// Partition1_4 - Object C not in container
    	            // Partition2_4 - Object O not in container
    	        	conteneur.ajouter(-1,-1);
    	        	// Partition3_1 - Container not full
    	        	//
    	        	conteneur.ajouter(C,O);
    	        }),
    		    () -> Assertions.assertEquals(O, conteneur.valeur(C))
    		);
    }
    
 
    
    
}
