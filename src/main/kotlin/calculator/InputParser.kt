package calculator

class InputParser(inputString: String) {

    private val inputString = inputString.trim()

    fun separator(): String? {
        if (inputString.hasNoSeparatorSection()) return null

        val separatorSection = inputString.substringBeforeLast(SEPARATOR_END)
        require(separatorSection.startsWith(SEPARATOR_START))
        return separatorSection.substringAfter(SEPARATOR_START)
            .also {
                require(it.isNotDigit())
            }
    }

    fun numbers(separators: Array<String> = emptyArray()): List<Int> {
        return inputString.substringAfterLast(SEPARATOR_END)
            .split(
                *separators.plus(defaultDelimiters)
            )
            .map {
                if (it.isNotDigit()) throw RuntimeException()
                it.toInt()
            }
    }

    private fun String.hasNoSeparatorSection(): Boolean {
        return !contains(SEPARATOR_END)
    }

    private fun String.isNotDigit(): Boolean {
        val number = toIntOrNull()
        return number == null || number < 0
    }


    companion object {
        private const val SEPARATOR_START = "//"
        private const val SEPARATOR_END = "\\n"
        private val defaultDelimiters = arrayOf(",", ":")
    }
}
