package calculator.dto

@JvmInline
value class PositiveNum(val value: String) {

    init {
        require(value.toInt() >= POSITIVE_THRESHOLD) { "음수는 입력할 수 없습니다." }
    }

    companion object {
        const val POSITIVE_THRESHOLD = 0
    }
}
