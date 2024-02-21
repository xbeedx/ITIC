package tests.structurels;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sudoku.Puzzle;

class testIsSolved {
	
	private Puzzle puzzle;

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
    	puzzle = null; // Reset the puzzle before each test
    }

    @AfterEach
    void tearDown() {
        // Release resources after each test
    	puzzle = null; // Ensure that puzzle is null after each test
    }

	@Test
	void isSolvedTest1() {
		//Ch2
		
		/*
		 * 0 < dimension0
		 * Box(0,0).isSolved()
		 * 1 < dimension0
		 * !Box(0,1).isSolved()
		*/
		String row1 = "1.3";
		String row2 = "231";
		String row3 = "312";
		puzzle= new Puzzle(row1 + row2 + row3);
		Assertions.assertFalse(puzzle.isSolved());
	}
	
	@Test
	void isSolvedTest2() {
		//Ch4
		/*
		 * 0 < dimension0
		 * 0 < dimension0
		 * Box(0,0).isSolved()
		 * 1 < dimension0
		 * Box(0,1).isSolved()
		 * 2 >= dimension0
		 * 1 < dimension0
		 * 0 < dimension0
		 * Box(1,0).isSolved()
		 * 1 < dimension0
		 * Box(1,1).isSolved()
		 * 2 >= dimension0
		 * 2 >= dimension0
		*/
		String row1 = "12";
		String row2 = "21";
		puzzle= new Puzzle(row1 + row2);
		Assertions.assertTrue(puzzle.isSolved());
	}
	
	@Test
	void isSolvedTest3() {
		//Ch5
		/*
		 * 0 < dimension0
		 * !Box(0,0).Solved()
		*/
		String row1 = ".23";
		String row2 = "231";
		String row3 = "312";
		puzzle= new Puzzle(row1 + row2 + row3);
		Assertions.assertFalse(puzzle.isSolved());
	}
	
	@Test
	void isSolvedTest4() {
		//Ch6
		/*
		 * 0 < dimension0
		 * Box(0,0).isSolved()
		 * 1 >= dimension0
		*/
		String row1 = "1";
		puzzle= new Puzzle(row1);
		Assertions.assertTrue(puzzle.isSolved());
	}
	
	@Test
	void isSolvedTest5() {
		//Ch3
		/*
		 * 0 < dimension0
		 * 0 < dimension0
		 * Box(0,0).isSolved()
		 * 1 < dimension0
		 * Box(0,1).isSolved()
		 * 2 >= dimension0
		 * 1 < dimension0
		 * 0 < dimension0
		 * Box(1,0).isSolved()
		 * 1 < dimension0
		 * !Box(1,1).isSolved()
		*/
		String row1 = "12";
		String row2 = "2.";
		puzzle= new Puzzle(row1 + row2);
		Assertions.assertFalse(puzzle.isSolved());
	}
	
	@Test
	void isSolvedTest6() {
		//Ch8
		/*
		 * 0 < dimension0
		 * 0 < dimension0
		 * Box(0,0).isSolved()
		 * 1 < dimension0
		 * !Box(0,1).isSolved()
		*/
		String row1 = "1.3";
		String row2 = "231";
		String row3 = "312";
		puzzle= new Puzzle(row1 + row2 + row3);
		Assertions.assertFalse(puzzle.isSolved());
	}
	
	@Test
	void isSolvedTest7() {
		//Ch9
		/*
		 * 0 < dimension0
		 * 0 < dimension0
		 * Box(0,0).isSolved()
		 * 1 < dimension0
		 * Box(0,1).isSolved()
		 * 2 >= dimension0
		 * 1 < dimension0
		 * 0 < dimension0
		 * !Box(1,0).isSolved()
		*/
		String row1 = "12";
		String row2 = ".1";
		puzzle= new Puzzle(row1 + row2);
		Assertions.assertFalse(puzzle.isSolved());
	}

}
