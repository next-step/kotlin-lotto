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
    
    private fun String.hasNoSeparatorSection(): Boolean {
        return !contains(SEPARATOR_END)
    }

    private fun String.isNotDigit() = toIntOrNull() == null


    companion object {
        private const val SEPARATOR_START = "//"
        private const val SEPARATOR_END = "\\n"
    }
}
