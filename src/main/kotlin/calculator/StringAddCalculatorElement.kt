package calculator

@JvmInline
value class StringAddCalculatorElement(val number: Int) {
    companion object {
        fun of(text: String): StringAddCalculatorElement {
            require(text.toIntOrNull() != null) { "숫자가 아닙니다." }
            require(text.toInt() >= 0) { "음수는 입력할 수 없습니다." }
            return StringAddCalculatorElement(text.toInt())
        }
    }
}
