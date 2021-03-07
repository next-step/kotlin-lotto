package stringaddcalculator.domain

class Calculator {
    fun add(text: String): Int {
        if (text.isEmpty()) return 0

        return parseExpression(text)?.sumBy(String::toInt) ?: run {
            text.split(",", ":")
                .map { Number(it) }
                .sumBy(Number::number)
        }
    }

    fun parseExpression(text: String): List<String>? {
        return Regex("//(.)\n(.*)").find(text)?.let {
            it.groupValues[2].split(it.groupValues[1])
        }
    }
}
