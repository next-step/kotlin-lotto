import java.lang.RuntimeException

val defaultDelimiterPattern = Regex("[,:]")
val customDelimiterPattern = Regex("(\\/\\/(.)\\\\n)(.*)")
val stringValidationPattern = Regex("^((\\/\\/)(.)(\\n))?d*(((.)d*)*)?\$")

class StringAddCalculator {

    var delimiter = defaultDelimiterPattern
        private set

    fun add(text: String): Int {
        if (text.isNullOrEmpty()) return 0
        if (text.length == 1) return text.toInt()
        return getTargetText(text).split(delimiter)
            .map {
                val number = it.toInt()
                isNegativeCheck(number)
                number
            }.reduce { sum, number ->
                sum + number
            }
    }

    fun getTargetText(text: String): String {
        return customDelimiterPattern.find(text)?.let {
            delimiter = Regex(it.groupValues[2])
            text.replace(it.groupValues[1], "")
        } ?: text
    }

    private fun isNegativeCheck(number: Int) {
        if (number < 0) throw RuntimeException()
    }
}