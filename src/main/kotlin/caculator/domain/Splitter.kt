package caculator.domain

class Splitter(
    private val value: String,
) {
    fun split(): List<String> =
        REGEX.find(value)
            ?.let {
                val (delimiter, numbers) = it.destructured
                numbers.split(delimiter)
            } ?: run { value.split(*DELIMITERS.toTypedArray()) }

    companion object {
        private val DELIMITERS = listOf(",", ":")

        private val REGEX = "//(.)\n(.*)".toRegex()
    }
}
