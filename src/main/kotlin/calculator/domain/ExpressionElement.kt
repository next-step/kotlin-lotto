package calculator.domain

sealed class ExpressionElement {

    class OperandElement(val value: Int) : ExpressionElement()
    class OperatorElement(val value: Operator) : ExpressionElement()
}
