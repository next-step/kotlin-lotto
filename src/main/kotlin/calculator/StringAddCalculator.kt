package calculator

class StringAddCalculator {

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }
        if (text.isInt()) {
            val toInt = text.toInt()
            require(toInt > 0) { "음수는 입력할 수 없습니다" }
            return toInt
        }

        val result = Regex("//(.)\n(.*)").find(text)
        result?.let {
            val customDelimiter = it.groupValues[1]
            return it.groupValues[2].split(customDelimiter).sumOf { number -> number.toInt() }
        }

        return text.split("[,:]".toRegex()).sumOf { it.toInt() }
    }
}

fun String.isInt(): Boolean = this.toIntOrNull() != null
