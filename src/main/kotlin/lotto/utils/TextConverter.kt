package lotto.utils

class TextConverter {

    fun toNumeric(text: String): Int {
        return text.toInt()
    }

    fun toNumerics(text: List<String>): List<Int> {
        return text.map { it.toInt() }
    }
}
