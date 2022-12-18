package step2.domain

data class Lotto(val numbers: List<Int>) {

    init {
        numbersSizeValidate()
        numberRangeValidate()
    }

    private fun numbersSizeValidate() {
        require(numbers.size == LOTTO_NUMBER_COUNT) { NEED_SIX_DIGIT_EXCEPTION_MESSAGE }
    }

    private fun numberRangeValidate() {
        numbers.forEach { number ->
            require(number > MIN_LOTTO_NUMBER || number < MAX_LOTTO_NUMBER) { "$MIN_LOTTO_NUMBER 과 $MAX_LOTTO_NUMBER 사이의 숫자를 입력해주세요." }
        }
    }

    companion object {
        private const val NEED_SIX_DIGIT_EXCEPTION_MESSAGE = "6자리의 번호가 필요합니다."
        private const val LOTTO_NUMBER_COUNT = 6
        private const val MIN_LOTTO_NUMBER = 1
        private const val MAX_LOTTO_NUMBER = 45
    }
}
