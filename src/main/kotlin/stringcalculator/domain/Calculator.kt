package stringcalculator.domain

class Calculator {
    companion object {
        fun getTotal(numbers: List<Int>): Int {
            return numbers.sum()
        }
    }
}
