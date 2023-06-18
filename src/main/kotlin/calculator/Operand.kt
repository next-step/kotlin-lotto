package calculator

class Operand(
    val operand: String
) {
    init {
        if (operand.toInt() < MINIMUM) {
            throw RuntimeException("$MINIMUM 보다 작을 수 없습니다.")
        }
    }

    companion object {
        private const val MINIMUM = 0
    }
}