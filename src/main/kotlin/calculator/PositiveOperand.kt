package calculator

class PositiveOperand(arg: String) {
    val value: Int
    init {
        value = arg.toInt()
        require(value >= 0) { "피연산자는 0 또는 양수 이어야 합니다." }
    }
}
