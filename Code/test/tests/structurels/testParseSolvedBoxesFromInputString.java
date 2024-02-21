package tests.structurels;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sudoku.Puzzle;
import sudoku.Box;

class testParseSolvedBoxesFromInputString {
	
	private Puzzle puzzle;
	String initialState;
	
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
    	initialState = "";
    }

    @AfterEach
    void tearDown() {
        // Release resources after each test
    	puzzle = null; // Ensure that puzzle is null after each test
    	initialState = "";
    }

	@Test
	void parseSolvedBoxesFromInputStringTest1() {
		//Ch1
		/*
		 * 0 < initialState0.length()
		 * Character.isDigit(initialState0.charAt(0)) && initialState0.charAt(0) != '0')
		 * 1 % dimension0 == 0
		 * 1 >= initialState0.length()
		*/
		initialState = "1";
		puzzle = new Puzzle(initialState);
		Assertions.assertEquals(List.of(new Box(1,0, 0, 1)), puzzle.getSolvedBoxes());
	}
	
	@Test
	void parseSolvedBoxesFromInputStringTest2() {
		//Ch5
		/*
		 * 0 < initialState0.length()
		 * !Character.isDigit(initialState0.charAt(0)) || initialState0.charAt(0) == '0')
		 * 1%dimension == 0
		 * 1 >= initialState0.length()
		*/
		initialState = "0";
		puzzle = new Puzzle(initialState);
		Assertions.assertEquals(Collections.emptyList(), puzzle.getSolvedBoxes());
	}
	
	@Test
	void parseSolvedBoxesFromInputStringTest3() {
		//Ch16
		/*
		 * 0 < initialState0.length()
		 * !Character.isDigit(initialState0.charAt(0)) || initialState0.charAt(0) == '0')
		 * 1 % dimension0 == 0
		 * 1 < initialState.length()
		 * !Character.isDigit(initialState0.charAt(1)) || initialState0.charAt(1) == '0')
		 * ++(1 % dimension0 ) % dimension == 0
		 * 2 >= initialState.length()
		*/
		String row1 = "0";
		String row2 = "0";
		initialState = row1 + row2;
		puzzle = new Puzzle(initialState);
		System.out.print(puzzle.getSolvedBoxes());
		Assertions.assertEquals(Collections.emptyList(), puzzle.getSolvedBoxes());
	}
	
	@Test
	void parseSolvedBoxesFromInputStringTest4() {
		//Ch17
		/*
		 * 0 < initialState0.length()
		 * !Character.isDigit(initialState0.charAt(0)) || initialState0.charAt(0) == '0')
		 * 1 % dimension0 == 0
		 * 1 < initialState.length()
		 * Character.isDigit(initialState0.charAt(1)) && initialState0.charAt(1) != '0'
		 * ++(1 % dimension0 ) % dimension == 0
		 * 2 >= initialState.length()
		*/
		String row1 = "0";
		String row2 = "1";
		initialState = row1 + row2;
		puzzle = new Puzzle(initialState);
		Assertions.assertEquals(List.of(new Box(1,1, 0, 1)), puzzle.getSolvedBoxes());
	}
	
	@Test
	void parseSolvedBoxesFromInputStringTest5() {
		//Ch20
		/*
		 * 0 < initialState0.length()
		 * Character.isDigit(initialState0.charAt(0)) && initialState0.charAt(0) != '0'
		 * 1 % dimension0 == 0
		 * 1< initialState0.length()
		 * !Character.isDigit(initialState0.charAt(1)) || initialState0.charAt(0) == '1')
		 * ++(1 % dimension0 ) % dimension == 0
		 * 2 >= initialState.length()
		*/
		String row1 = "1";
		String row2 = "0";
		initialState = row1 + row2;
		puzzle = new Puzzle(initialState);
		Assertions.assertEquals(List.of(new Box(1,0, 0, 1)), puzzle.getSolvedBoxes());
	}
	
	@Test
	void parseSolvedBoxesFromInputStringTest6() {
		//Ch21
		/*
		 * 0 < initialState0.length()
		 * Character.isDigit(initialState0.charAt(0)) && initialState0.charAt(0) != '0'
		 * 1 % dimension0 == 0
		 * 1< initialState0.length()
		 * Character.isDigit(initialState0.charAt(1)) && initialState0.charAt(0) != '1')
		 * ++(1 % dimension0 ) % dimension == 0
		 * 2 >= initialState.length()
		*/
		String row1 = "1";
		String row2 = "2";
		initialState = row1 + row2;
		puzzle = new Puzzle(initialState);
		Assertions.assertEquals(List.of(new Box(1,0, 0, 1), new Box(1,1, 0, 2)), puzzle.getSolvedBoxes());
	}

}
