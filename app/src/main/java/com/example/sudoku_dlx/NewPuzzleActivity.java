package com.example.sudoku_dlx;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;

public class NewPuzzleActivity extends PuzzleActivity {
    DancingLinksAlgorithm engine = new DancingLinksAlgorithm();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_puzzle);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String gridString = intent.getStringExtra(MainActivity.NEW_MESSAGE);

        // if the length of the puzzle is less than 81, return.
        if (gridString.length() != NUMBER_OF_CELLS * NUMBER_OF_CELLS) {
            Snackbar.make(findViewById(R.id.myCoordinatorLayout), R.string.invalid_puzzle,
                    Snackbar.LENGTH_SHORT)
                    .show();
            return;
        }

        grid = new int[NUMBER_OF_CELLS][NUMBER_OF_CELLS];
        int row, column;
        int index = 0;

        // read in the puzzle string into a grid.
        for (char c : gridString.toCharArray()) {
            row = index / NUMBER_OF_CELLS;
            column = index % NUMBER_OF_CELLS;

            // guaranteed to be a digit because of the constraint during the input.
            grid[row][column] = Character.getNumericValue(c);
            index++;
        }

        // initialize the engine and display the original grid
        displayGrid(convertGridToString(grid));
    }

    /** Called when the user taps the Solve button */
    public void solvePuzzle(View view) {
        int[][] result = engine.solve(grid);
        Snackbar.make(findViewById(R.id.myCoordinatorLayout), R.string.message_solved,
                Snackbar.LENGTH_SHORT)
                .show();

        // display the array list onto the displayed puzzle
        displayGrid(convertGridToString(result));
    }
}
