/**
 * Code is from:
 * https://www.baeldung.com/java-sudoku,
 * https://github.com/eugenp/tutorials/tree/master/algorithms-miscellaneous-2.
 * Minor changes made to the code to make it a library.
 */
package com.example.sudoku_dlx;

class ColumnNode extends DancingNode {
    int size;
    String name;

    ColumnNode(String n) {
        super();
        size = 0;
        name = n;
        C = this;
    }

    void cover() {
        unlinkLR();
        for (DancingNode i = this.D; i != this; i = i.D) {
            for (DancingNode j = i.R; j != i; j = j.R) {
                j.unlinkUD();
                j.C.size--;
            }
        }
    }

    void uncover() {
        for (DancingNode i = this.U; i != this; i = i.U) {
            for (DancingNode j = i.L; j != i; j = j.L) {
                j.C.size++;
                j.relinkUD();
            }
        }
        relinkLR();
    }
}