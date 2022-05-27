package calculator.number

object PositiveNumber {
    fun get(input: String) = input
        .toInt()
        .takeIf { it >= 0 }
        ?: throw IllegalArgumentException("음수가 아닌 정수가 아닙니다.")
}
