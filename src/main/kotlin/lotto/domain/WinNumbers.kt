package lotto.domain

data class WinNumbers(val numbers: List<Int>) {
    init {
        require(numbers.distinct().size == Lotto.LOTTO_NUMBER_SIZE) { WINNING_NUMBER_ERROR_MESSAGE }
        require(numbers.find { it !in Lotto.LOTTO_MIN_NUMBER..Lotto.LOTTO_MAX_NUMBER } == null) { WINNING_NUMBER_RANGE_ERROR_MESSAGE }
    }

    fun getMatchCount(lotto: Lotto): Int = lotto.numbers.count { it in numbers }

    companion object {
        private const val WINNING_NUMBER_ERROR_MESSAGE = "당첨번호는 ${Lotto.LOTTO_NUMBER_SIZE}개여야 합니다"
        private const val WINNING_NUMBER_RANGE_ERROR_MESSAGE =
            "로또 번호는 ${Lotto.LOTTO_MIN_NUMBER} ~ ${Lotto.LOTTO_MAX_NUMBER}사이여야 합니다"
    }
}
