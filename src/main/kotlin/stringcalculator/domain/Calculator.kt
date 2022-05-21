package stringcalculator.domain

class Calculator {

    companion object {
        fun getTotalSum(numbers: List<Int>): Int {
            return numbers.sum()
        }
    }
}
