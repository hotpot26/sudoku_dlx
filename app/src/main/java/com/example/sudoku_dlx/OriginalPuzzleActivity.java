package com.example.sudoku_dlx;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;

public class OriginalPuzzleActivity extends PuzzleActivity {
    private int [][] original = {
            {8, 5, 6, 0, 1, 4, 7, 3, 0},
            {0, 9, 0, 0, 0, 0, 0, 0, 0},
            {2, 4, 0, 0, 0, 0, 1, 6, 0},
            {0, 6, 2, 0, 5, 9, 3, 0, 0},
            {0, 3, 1, 8, 0, 2, 4, 5, 0},
            {0, 0, 5, 3, 4, 0, 9, 2, 0},
            {0, 2, 4, 0, 0, 0, 0, 7, 3},
            {0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 1, 8, 6, 3, 0, 2, 9, 4}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_original_puzzle);

        grid = original;

        // display the int grid onto the displayed puzzle
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
