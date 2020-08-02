package textcalculator

class TextCalculator(
    private val ioManager: IOManager,
    private val parser: Parser
) {
    fun calculate(text: String): Int {
        return Calculator.sum(parser.parse(text))
    }

    fun execute() {
        val text = ioManager.input() ?: ""
        ioManager.output("${calculate(text)}")
    }
}
