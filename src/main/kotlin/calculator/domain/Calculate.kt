package calculator.domain

interface Calculate {

    fun calculate(expression: Expression): Int
}
