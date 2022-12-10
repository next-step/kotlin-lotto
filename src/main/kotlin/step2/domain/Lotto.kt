package step2.domain

data class Lotto(val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { NEED_SIX_DIGIT_EXCEPTION_MESSAGE }
    }

    companion object {
        private const val NEED_SIX_DIGIT_EXCEPTION_MESSAGE = "6자리의 번호가 필요합니다."
    }
}

