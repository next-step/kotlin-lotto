package calculator

object Parser {

    fun getOperand(operand: String?):Int {
        if(operand.isNullOrBlank()) return 0
        return operand.toInt()
    }
}
