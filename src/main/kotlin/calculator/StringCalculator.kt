package calculator

object StringCalculator {
    fun add(expression: String?):Int {
        return Parser.parse(expression).sum()
    }
}
