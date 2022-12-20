package calculator.domain

sealed interface ExpressionElement {

    class OperandElement(val value: Int) : ExpressionElement
    class OperatorElement(val value: Operator) : ExpressionElement
}
