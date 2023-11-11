package calculator.domain

@JvmInline
value class StringNumber private constructor(val value: Int) {

    companion object {
        fun valueOf(value: String): StringNumber {
            require(value.toIntOrNull() != null) {
                "숫자 이외의 값일 수 없습니다."
            }
            require(value.toInt() >= 0) {
                "숫자는 음수일 수 없습니다."
            }
            return StringNumber(value.toInt())
        }
    }
}
