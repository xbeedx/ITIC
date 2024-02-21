package sudoku;

public class exemple_sudoku {

	public static void main(String[] args) {
		String row1 = "..3.2.6..";
        String row2 = "9..3.5..1";
        String row3 = "..18.64..";
        String row4 = "..81.29..";
        String row5 = "7.......8";
        String row6 = "..67.82..";
        String row7 = "..26.95..";
        String row8 = "8..2.3..9";
        String row9 = "..5.1.3..";

        Puzzle puzzle = new Puzzle(row1 + row2 + row3 + row4 + row5 + row6 + row7 + row8 + row9);
        
        puzzle.solve();
			
		System.out.println( puzzle.solutionAsSingleString() );
        
	}
}
