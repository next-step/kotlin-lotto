package calculator.stringcalculator.config

import calculator.stringcalculator.Calculator
import calculator.stringcalculator.Number
import calculator.stringcalculator.StringSummingCalculator
import calculator.stringcalculator.splitter.CustomDelimiterSplitter
import calculator.stringcalculator.splitter.DefaultDelimiterSplitter
import calculator.stringcalculator.splitter.Splitter

object CalculatorConfig {

    val splitters: List<Splitter<String, List<String>>> by lazy {
        listOf(
            customDelimiterSplitter, defaultDelimiterSplitter
        )
    }

    val calculator: Calculator<String, Number> by lazy { StringSummingCalculator(splitters = splitters) }

    val defaultDelimiterSplitter: DefaultDelimiterSplitter by lazy { DefaultDelimiterSplitter }
    val customDelimiterSplitter: CustomDelimiterSplitter by lazy { CustomDelimiterSplitter }
}
