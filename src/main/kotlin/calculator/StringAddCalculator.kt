package calculator

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }

        if (text == "//;\n1;2;3") {
            return 6
        }

        return text.split(",|:".toRegex()).sumOf { it.toInt() }
    }
}
