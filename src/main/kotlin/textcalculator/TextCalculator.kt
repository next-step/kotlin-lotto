package textcalculator

class TextCalculator(
    private val ioManager: IOManager,
    private val parser: Parser,
    private val calculator: Calculator
) {
    fun calculate(text: String): Int {
        return calculator.sum(parser.parse(text))
    }

    fun execute() {
        val text = ioManager.input() ?: ""
        ioManager.output("${calculate(text)}")
    }
}
