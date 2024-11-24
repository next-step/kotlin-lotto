package calculator.model.operator

interface Operator {
    fun apply(
        a: Int,
        b: Int,
    ): Int
}
