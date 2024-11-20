package calculator

class Converter {
    fun toPositiveNumbers(texts: List<String>): List<Int> =
        texts.map { it.toIntOrNull()?.takeIf { it >= 0 } ?: error("Invalid number: $it") }
}
