package calculator

object Splitter {
    fun getNumberStrings(text: String): List<String> {
        val result = Regex("//(.)\n(.*)").find(text)

        if (result != null) {
            val (separator, input) = result.destructured
            return input.split(separator)
        }
        return text.split("[,:]".toRegex())
    }
}
