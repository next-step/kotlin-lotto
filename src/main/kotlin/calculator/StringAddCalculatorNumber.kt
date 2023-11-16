package calculator

@JvmInline
value class StringAddCalculatorNumber(val number: Int) {

    init {
        require(number >= 0) { "음수는 입력할 수 없습니다." }
    }

    companion object {
        fun of(text: String): StringAddCalculatorNumber {
            require(text.toIntOrNull() != null) { "숫자가 아닙니다." }
            return StringAddCalculatorNumber(text.toInt())
        }
    }
}
