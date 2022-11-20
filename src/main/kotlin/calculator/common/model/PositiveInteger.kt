package calculator.common.model

@JvmInline
value class PositiveInteger(
    val value: Int
) {
    init {
        require(value >= 0) { "양의 정수는 0과 같거나 커야합니다." }
    }
}
