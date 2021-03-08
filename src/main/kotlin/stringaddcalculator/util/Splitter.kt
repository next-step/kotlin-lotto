package stringaddcalculator.util

class Splitter(private val delimiter: String? = null) : AbstractSplitter {

    override fun split(input: String): List<String> {
        if (delimiter.isNullOrBlank()) {
            return DefaultSplitter.split(input)
        }
        return input.split(delimiter)
    }
}
