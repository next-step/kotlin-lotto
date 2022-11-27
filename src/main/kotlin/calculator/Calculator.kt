package calculator

object Calculator {

    fun calculate(text: String?): Int {
        val numbers = NumbersExtractor.run(text)
        return numbers.sumOf {
            it.value
        }
    }
}