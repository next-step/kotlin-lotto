package calulator

class StringAddCalculator {
    fun calculate(text: String): Int {
        val numbers = Parser.parse(text)
        return numbers.sum
    }
}
