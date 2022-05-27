package calculator.number

@JvmInline
value class PositiveNumber(private val input: String) {
    val value: Int
        get() = input
            .toInt()
            .takeIf { it >= 0 }
            ?: throw IllegalArgumentException("음수가 아닌 정수가 아닙니다.")
}
