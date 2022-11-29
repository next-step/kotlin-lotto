package caculator.domain

class Splitter(
    private val value: String,
) {
    private val regex = REGEX_CUSTOM.toRegex()

    fun split(): List<String> =
        regex.find(value)
            ?.let {
                val (delimiter, numbers) = it.destructured
                numbers.split(delimiter)
            } ?: run { value.split(*DELIMITERS.toTypedArray()) }

    companion object {
        private val DELIMITERS = listOf(",", ":")

        private const val REGEX_CUSTOM = "//(.)\n(.*)"
    }
}
