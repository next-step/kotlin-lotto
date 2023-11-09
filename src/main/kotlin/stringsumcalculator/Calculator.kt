package stringsumcalculator

class Calculator {

    fun execute(text: String?): Int {
        return if (text.isNullOrBlank()) {
            0
        } else {
            getDestructured(text)?.let {
                sum(it.component2(), it.component1())
            } ?: sum(text, DEFAULT_DELIMITER)
        }
    }

    fun getDestructured(text: String): MatchResult.Destructured? {
        return CUSTOM_SEARCH_PATTERN.find(text)?.destructured
    }

    fun sum(value: String, delimiter: String): Int {
        return value.split(delimiter.toRegex()).sumOf {
            it.toNumber()
        }
    }

    private fun String.toNumber(): Int {
        val value = this.toIntOrNull()
        if (value == null || value < 0) {
            throw RuntimeException()
        }
        return value
    }

    companion object {
        private const val DEFAULT_DELIMITER = ",|:"
        private val CUSTOM_SEARCH_PATTERN: Regex = Regex("//(.)\n(.*)")
    }
}