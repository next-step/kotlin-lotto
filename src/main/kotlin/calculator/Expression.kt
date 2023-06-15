package calculator

class Expression(input: String?) {

    val numbers: List<Int>
    init {
        val delimiterDetector = DelimiterDetector(input)
        val numberParser = NumberParser(delimiterDetector.stringInput, delimiterDetector.delimiter)
        numbers = numberParser.numbers
    }

    fun sum(): Int {
        return numbers.sum()
    }
}
