package calculator.domain

class AddCalculator {
    private var _sumResult: Int = 0
    val sumResult: Int
        get() = _sumResult

    fun add(input: Int): AddCalculator {
        if (input < 0) throw RuntimeException("음수를 입력할 수 없어요.")
        return this.apply {
            _sumResult += input
        }
    }
}
