package calculate

class Splitter(delimiterSetter: DelimiterSetter) {
    val numbers = splitStrings(delimiterSetter.delimiter, delimiterSetter.body)

    private fun splitStrings(delimiter: List<String>, body: String): List<Number> {
        val inputs = body.split(*delimiter.toTypedArray())

        return inputs.map { Number(it) }
    }
}
