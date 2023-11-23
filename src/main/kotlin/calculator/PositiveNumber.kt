package calculator

@JvmInline
value class PositiveNumber(private val number: Int) {
    init {
        require(number >= 0) {
            throw RuntimeException("문자열 계산기에 음수를 전달할 수 없습니다.")
        }
    }
}