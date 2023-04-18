package homework13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuadraticEquationTest {

    @Test
    void solveTestTwoRoots() {
        QuadraticEquation equation = new QuadraticEquation(1, -5, 6);
        equation.solve();
        assertEquals(3.0, equation.getX1());
        assertEquals(2.0, equation.getX2());
    }

    @Test
    void solveTestOneRoot() {
        QuadraticEquation equation = new QuadraticEquation(1, -4, 4);
        equation.solve();
        assertEquals(2.0, equation.getX1());
        assertEquals(2.0, equation.getX2());
    }

    @Test
    public void testNoRoots() {
        QuadraticEquation equation = new QuadraticEquation(1, 2, 3);
        equation.solve();
        assertTrue(Double.isNaN(equation.getX1()));
        assertTrue(Double.isNaN(equation.getX2()));
    }
}