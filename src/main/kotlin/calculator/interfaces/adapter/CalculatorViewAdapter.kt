package calculator.interfaces.adapter

import calculator.application.calculator.Calculator
import calculator.application.parser.Parser
import calculator.application.parser.impl.ParsingException
import calculator.common.model.PositiveIntegers
import calculator.interfaces.input.InputPlugin
import calculator.interfaces.output.OutputPlugin

class CalculatorViewAdapter(
    private val inputPlugin: InputPlugin,
    private val outputPlugin: OutputPlugin,
    private val calculator: Calculator,
    private val parser: Parser
) : ViewAdapter {

    override fun start() {
        val positiveIntegers = queryNumber()
        val result = calculator.multiplePlus(positiveIntegers)
        outputPlugin.output("결과: $result")
    }

    private fun queryNumber(): PositiveIntegers =
        try {
            val input = inputPlugin.inputPositiveInteger()
            PositiveIntegers(parser.parseToPositiveIntegerList(input))
        } catch (e: ParsingException) {
            outputPlugin.output(e.message)
            queryNumber()
        } catch (e: Exception) {
            outputPlugin.output("알 수 없는 에러입니다.")
            queryNumber()
        }
}
