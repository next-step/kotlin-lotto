package calculator.expression

class Expression private constructor(val numbers: List<Int>) {

    fun sum(): Int {
        return numbers.sum()
    }

    companion object {
        fun of(input: String?): Expression {
            val delimiterDetector = DelimiterDetector.from(input)
            val numberParser = NumberParser.of(delimiterDetector.stringInput, delimiterDetector.delimiter)
            return Expression(numberParser.numbers)
        }
    }
}
