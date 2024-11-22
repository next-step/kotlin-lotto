package additionparser.application

import additionparser.core.Calculator
import additionparser.core.StringParser

class AdditionParserService {
    fun calculate(string: String?): Int {
        val numberList = StringParser.parse(string)
        return Calculator.sum(numberList)
    }
}
