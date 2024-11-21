package calculator

class Operands(private val operands: List<Int>) {
    init {
        require(operands.none { it < 0 }) { throw RuntimeException("피연산자로 음수는 허용하지 않습니다.") }
    }

    fun sum(): Int = operands.sum()
}
