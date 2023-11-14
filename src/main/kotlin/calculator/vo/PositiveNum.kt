package calculator.vo

@JvmInline
value class PositiveNum(val value: Int) {

    init {
        require(value >= POSITIVE_THRESHOLD) { "음수는 입력할 수 없습니다." }
    }

    companion object {
        const val POSITIVE_THRESHOLD = 0
    }
}
