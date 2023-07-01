package stringaddcalculator.domain

class StringAddCalculator {

    fun calculate(input: String): Int {
        val numbers = NumbersGenerator(input).generate()
        return numbers.sum()
    }
}
