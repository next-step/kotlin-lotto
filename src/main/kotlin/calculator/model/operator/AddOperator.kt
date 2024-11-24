package calculator.model.operator

class AddOperator : Operator {
    override fun apply(
        a: Int,
        b: Int,
    ): Int {
        return a + b
    }
}
