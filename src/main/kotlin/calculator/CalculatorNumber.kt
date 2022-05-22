package calculator

class CalculatorNumber(num: Int?) {
    var num: Int = num!!

    init {
        require(num != null) {
            throw RuntimeException(NOT_NUMBER_MESSAGE)
        }
        require(num >= MIN_NUMBER) {
            throw RuntimeException(negative_NUMBER_MESSAGE)
        }
    }

    companion object {
        private const val MIN_NUMBER = 0
        private const val NOT_NUMBER_MESSAGE = "숫자가 아닌 다른 값이 올 수 없습니다."
        private const val negative_NUMBER_MESSAGE = "음수 값이 올 수 없습니다."
    }
}
