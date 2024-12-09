package calculator.domain

class AddCalculator {
    var sumResult: Int = 0
    private set

    fun add(input: Int): AddCalculator {
        if (input < 0) throw RuntimeException("음수를 입력할 수 없어요.")
        return this.apply {
            sumResult += input
        }
    }
}
