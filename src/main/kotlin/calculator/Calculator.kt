package calculator

object Calculator {

    fun calculate(text: String?): Int {
        val numbers = NumbersExtractor.extract(text)
        return numbers.sumOf {
            it.value
        }
    }
}