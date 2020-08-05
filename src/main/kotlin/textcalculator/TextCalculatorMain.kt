package textcalculator

fun main() {
    val ioManager = IOManager()

    TextCalculator(Parser()).execute(ioManager)
}
