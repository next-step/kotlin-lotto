package calculator

class Converter {
    fun toPositiveNumber(text: String): Int = text.toIntOrNull()?.takeIf { it >= 0 } ?: error("0보다 큰 숫자가 아닙니다.")
}
