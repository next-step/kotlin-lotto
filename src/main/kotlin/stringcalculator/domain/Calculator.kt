package stringcalculator.domain

object Calculator {
    fun getTotal(numbers: List<Int>): Int {
        return numbers.sum()
    }
}
