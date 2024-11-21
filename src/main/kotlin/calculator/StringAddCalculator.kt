package calculator

class StringAddCalculator {
    fun add(text: String?): Int {
        val operands: List<Int> = TextParser.parse(text)
        return Operands(operands).sum()
    }
}
