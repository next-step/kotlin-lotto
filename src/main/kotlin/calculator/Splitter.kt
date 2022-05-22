package calculator

object Splitter {
    fun getNumbers(text: String): List<Int?> {
        val result = Regex("//(.)\n(.*)").find(text)

        if (result != null) {
            val (separator, input) = result.destructured
            return input.split(separator)
                .map { it.toIntOrNull() }
        }
        return text.split("[,:]".toRegex())
            .map { it.toIntOrNull() }
    }
}
