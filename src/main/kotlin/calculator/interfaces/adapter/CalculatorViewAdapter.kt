package calculator.interfaces.adapter

import calculator.application.calculator.Calculator
import calculator.application.parser.Parser
import calculator.application.parser.ParsingException
import calculator.common.PositiveInteger
import calculator.interfaces.input.InputPlugin
import calculator.interfaces.output.OutputPlugin

class CalculatorViewAdapter(
    private val inputPlugin: InputPlugin,
    private val outputPlugin: OutputPlugin,
    private val calculator: Calculator,
    private val parser: Parser
) : ViewAdapter {

    override fun start() {
        val numberList = queryNumber()
        val result = calculator.multiplePlus(numberList)
        outputPlugin.output("결과: $result")
    }

    private fun queryNumber(): List<PositiveInteger> =
        try {
            val input = inputPlugin.input()
            parser.parse(input)
        } catch (e: ParsingException) {
            outputPlugin.output(e.message)
            queryNumber()
        } catch (e: Exception) {
            outputPlugin.output("알 수 없는 에러입니다.")
            queryNumber()
        }
}
