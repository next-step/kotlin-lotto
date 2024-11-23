package lotto.domain

data class CorrectNumbers(
    val values: Set<Int>,
) {
    init {
        require(values.size == CORRECT_NUMBER_COUNT) {
            "[CorrectNumbers] 당첨 번호의 개수가 6개가 아닙니다. | 당첨번호: '$values'"
        }
    }

    companion object {
        private const val CORRECT_NUMBER_COUNT = 6
    }
}
