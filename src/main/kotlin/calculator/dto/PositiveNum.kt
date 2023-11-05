package calculator.dto

@JvmInline
value class PositiveNum(val value: String) {

    init {
        require(value.toInt() >= 0) { "음수는 입력할 수 없습니다." }
    }
}
