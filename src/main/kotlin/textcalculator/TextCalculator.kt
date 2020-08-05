package textcalculator

class TextCalculator(
    private val parser: Parser
) {
    fun calculate(text: String): Int {
        return Calculator.sum(parser.parse(text))
    }

    fun execute(ioManager: IOManager) {
        val text = ioManager.input() ?: ""
        ioManager.output("${calculate(text)}")
    }
}
