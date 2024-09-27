package copilot.ds.dk.guideproject

import org.junit.Test
import org.junit.Assert.*

class FourthViewTest {

    private val fourthView = FourthView()

    @Test
    fun testEvaluateExpressionAddition() {
        val expression = "1+1"
        val result = fourthView.evaluateExpression(expression)
        assertEquals(2.0, result, 0.0)
    }

    @Test
    fun testEvaluateExpressionSubtraction() {
        val expression = "5-2"
        val result = fourthView.evaluateExpression(expression)
        assertEquals(3.0, result, 0.0)
    }

    @Test
    fun testEvaluateExpressionMultiplication() {
        val expression = "3*4"
        val result = fourthView.evaluateExpression(expression)
        assertEquals(12.0, result, 0.0)
    }

    @Test
    fun testEvaluateExpressionDivision() {
        val expression = "20/4"
        val result = fourthView.evaluateExpression(expression)
        assertEquals(5.0, result, 0.0)
    }

    @Test
    fun testEvaluateExpressionComplex() {
        val expression = "2+3*4-5/2"
        val result = fourthView.evaluateExpression(expression)
        assertEquals(11.5, result, 0.0)
    }

    @Test
    fun testEvaluateExpressionWithParentheses() {
        val expression = "2*(3+4)"
        val result = fourthView.evaluateExpression(expression)
        assertEquals(14.0, result, 0.0)
    }
}