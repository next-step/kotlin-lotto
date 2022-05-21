package calculator

class Calculator(private val numbers: List<Int>) {
    var sum: Int = 0
        private set

    fun calculate() {
        sum = numbers.sum()
    }
}
