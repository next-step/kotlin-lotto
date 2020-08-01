package stringAddCalculator

class StringAddCalculator {
    fun add(text: String): Int {
        if (text.isBlank()) return 0
        if (text.length == 1) return text.toInt()
        val texts = text.split(",", ":").map { it.toInt() }
        return texts.reduce { total, number -> total + number }
    }
}
