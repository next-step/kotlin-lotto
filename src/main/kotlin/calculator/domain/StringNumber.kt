package calculator.domain

@JvmInline
value class StringNumber(private val value: String) {

    init {
        require(value.toIntOrNull() != null) {
            "숫자 이외의 값일 수 없습니다."
        }
        require(value.toInt() >= 0) {
            "숫자는 음수일 수 없습니다."
        }
    }

    fun toInt(): Int = value.toInt()
}
