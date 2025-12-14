package calc;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private Calculator calc;

    public static class Calculator {
        public int add(int a, int b) {
            return a + b;
        }

        public int subtract(int a, int b) {
            return a - b;
        }

        public int multiply(int a, int b) {
            return a * b;
        }

        public int divide(int a, int b) {
            if (b == 0) {
                throw new ArithmeticException("Division by zero not allowed");
            }
            return a / b;
        }
    }

    @BeforeEach
    void setUp() {
        calc = new Calculator();
    }

    @Nested
    @DisplayName("Addition Tests")
    class AdditionTests {
        @Test
        @DisplayName("Adding two positive numbers")
        void testAddPositiveNumbers() {
            assertEquals(5, calc.add(2, 3), "2 + 3 should equal 5");
        }

        @Test
        @DisplayName("Adding negative and positive numbers")
        void testAddNegativeAndPositive() {
            assertEquals(0, calc.add(-2, 2), "-2 + 2 should equal 0");
        }
    }

    @Nested
    @DisplayName("Subtraction Tests")
    class SubtractionTests {
        @Test
        @DisplayName("Subtracting two positive numbers")
        void testSubtractPositiveNumbers() {
            assertEquals(1, calc.subtract(3, 2), "3 - 2 should equal 1");
        }

        @Test
        @DisplayName("Subtracting from a negative number")
        void testSubtractFromNegative() {
            assertEquals(-5, calc.subtract(-2, 3), "-2 - 3 should equal -5");
        }
    }

    @Nested
    @DisplayName("Multiplication Tests")
    class MultiplicationTests {
        @Test
        @DisplayName("Multiplying two positive numbers")
        void testMultiplyPositiveNumbers() {
            assertEquals(6, calc.multiply(2, 3), "2 * 3 should equal 6");
        }

        @Test
        @DisplayName("Multiplying by zero")
        void testMultiplyByZero() {
            assertEquals(0, calc.multiply(0, 10), "0 * 10 should equal 0");
        }
    }

    @Nested
    @DisplayName("Division Tests")
    class DivisionTests {
        @Test
        @DisplayName("Dividing two positive numbers")
        void testDividePositiveNumbers() {
            assertEquals(2, calc.divide(6, 3), "6 / 3 should equal 2");
        }

        @Test
        @DisplayName("Division by zero throws exception")
        void testDivisionByZero() {
            Exception exception = assertThrows(ArithmeticException.class, () -> {
                calc.divide(5, 0);
            });
            assertEquals("Division by zero not allowed", exception.getMessage());
        }
    }
}