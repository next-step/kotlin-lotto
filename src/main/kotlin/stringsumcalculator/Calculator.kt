package stringsumcalculator

class Calculator {

    fun excute(text: String?): Int {
        return if (text.isNullOrBlank()) {
            0
        } else if (text.startsWith("//")) {
            val (delimiter, value) = getDelimiterAndValue(text)
            sum(value, delimiter)
        } else {
            sum(text, ",|:")
        }
    }

    fun getDelimiterAndValue(text: String): Pair<String, String> {
        val (delimiter, value) = Regex("//(.)\n(.*)").find(text)!!.destructured
        return delimiter to value
    }

    fun sum(value: String, delimiter: String): Int {
        return value.split(delimiter.toRegex()).sumOf {
            if (!it.matches(Regex("[0-9]+")) || it.toInt() < 0) {
                throw RuntimeException()
            }
            it.toInt()
        }
    }
}