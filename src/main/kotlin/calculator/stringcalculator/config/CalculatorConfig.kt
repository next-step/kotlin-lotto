package calculator.stringcalculator.config

import calculator.stringcalculator.Calculator
import calculator.stringcalculator.PositiveNumber
import calculator.stringcalculator.StringSummingCalculator
import calculator.stringcalculator.splitter.CustomDelimiterSplitter
import calculator.stringcalculator.splitter.DefaultDelimiterSplitter
import calculator.stringcalculator.splitter.StringSplitter

object CalculatorConfig {

    val splitters: List<StringSplitter> by lazy {
        listOf(
            customDelimiterSplitter, defaultDelimiterSplitter
        )
    }

    val calculator: Calculator<String, PositiveNumber> by lazy { StringSummingCalculator(splitters = splitters) }

    val defaultDelimiterSplitter: DefaultDelimiterSplitter by lazy { DefaultDelimiterSplitter }
    val customDelimiterSplitter: CustomDelimiterSplitter by lazy { CustomDelimiterSplitter(Regex("//([^0-9].*)\n(.*)")) }
}
