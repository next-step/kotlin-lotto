package calculator.assemble

import calculator.application.calculator.Calculator
import calculator.application.calculator.CalculatorFactory
import calculator.application.parser.DelimiterParser
import calculator.application.parser.Parser
import calculator.interfaces.adapter.CalculatorViewAdapter
import calculator.interfaces.input.InputConsole
import calculator.interfaces.input.InputPlugin
import calculator.interfaces.output.OutputConsole
import calculator.interfaces.output.OutputPlugin

object ObjectAssemble {

    fun viewAdapter(): CalculatorViewAdapter = CalculatorViewAdapter(
        inputPlugin = inputPlugin(),
        outputPlugin = outputPlugin(),
        calculator = calculator(),
        parser = parser()
    )

    private fun inputPlugin(): InputPlugin = InputConsole
    private fun outputPlugin(): OutputPlugin = OutputConsole
    private fun calculator(): Calculator = CalculatorFactory.generate()
    private fun parser(): Parser = DelimiterParser
}
