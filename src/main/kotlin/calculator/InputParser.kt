package calculator

class InputParser(inputString: String) {

    private val inputString = inputString.trim()

    fun separator(): String? {
        if (!inputString.hasSeparatorSection()) return null

        val separatorSection = inputString.substringBeforeLast(SEPARATOR_END)
        require(separatorSection.startsWith(SEPARATOR_START))
        return separatorSection.substringAfter(SEPARATOR_START)
            .also {
                require(it.isNotPositiveInteger())
            }
    }

    fun numbers(separators: Array<String> = emptyArray()): List<Int> {
        return inputString.substringAfterLast(SEPARATOR_END)
            .split(
                *separators.plus(defaultDelimiters)
            )
            .map {
                if (it.isEmpty()) return@map 0
                if (it.isNotPositiveInteger()) throw RuntimeException("invalid number format $it")
                it.toInt()
            }
    }

    private fun String.hasSeparatorSection(): Boolean {
        return startsWith(SEPARATOR_START) && contains(SEPARATOR_END)
    }

    private fun String.isNotPositiveInteger(): Boolean {
        val number = toIntOrNull()
        return number == null || number < 0
    }


    companion object {
        private const val SEPARATOR_START = "//"
        private const val SEPARATOR_END = "\\n"
        private val defaultDelimiters = arrayOf(",", ":")
    }
}
