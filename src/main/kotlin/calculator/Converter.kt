package calculator

class Converter {
    fun toNumbers(texts: List<String>): List<Int> = texts.map { it.toIntOrNull() ?: error("Invalid number: $it") }
}
