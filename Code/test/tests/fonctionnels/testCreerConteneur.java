package tests.fonctionnels;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testEtat.Conteneur;

class testCreerConteneur {
	
	 private Conteneur conteneur;

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
    }

    @AfterEach
    void tearDown() {
        // Release resources after each test
        conteneur = null; // Ensure that conteneur is null after each test
    }

    @Test
    void constructeurTest1() {
        // Test1: N > 1
        try {
            conteneur = new Conteneur(2); 
            Assertions.assertNotNull(conteneur);
        } catch (Exception e) {
            Assertions.fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    void constructeurTest2() {
        // Test2: N ≤ 1
        Assertions.assertThrows(testEtat.ErreurConteneur.class, () -> new Conteneur(1));
    }

    @Test
    void constructeurTest3() {
        // Test3: N = null
    	Assertions.assertThrows(Exception.class, () -> new Conteneur((Integer) null));
    }
	    

}
