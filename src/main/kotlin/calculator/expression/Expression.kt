package calculator.expression

class Expression private constructor(input: String?) {

    val numbers: List<Int>
    init {
        val delimiterDetector = DelimiterDetector(input)
        val numberParser = NumberParser(delimiterDetector.stringInput, delimiterDetector.delimiter)
        numbers = numberParser.numbers
    }

    fun sum(): Int {
        return numbers.sum()
    }

    companion object {
        fun of(input: String?): Expression {
            return Expression(input)
        }
    }
}
