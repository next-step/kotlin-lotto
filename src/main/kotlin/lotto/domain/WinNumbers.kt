package lotto.domain

data class WinNumbers(val numbers: List<LottoNumber>) {
    init {
        require(numbers.distinct().size == Lotto.LOTTO_NUMBER_SIZE) { WINNING_NUMBER_ERROR_MESSAGE }
        require(numbers.find { it !in LottoNumber.LOTTO_MIN_NUMBER..LottoNumber.LOTTO_MAX_NUMBER } == null) { LottoNumber.NUMBER_RANGE_ERROR_MESSAGE }
    }

    fun getMatchCount(lotto: Lotto): Int = numbers.count { it in lotto }

    companion object {
        private const val WINNING_NUMBER_ERROR_MESSAGE = "당첨번호는 ${Lotto.LOTTO_NUMBER_SIZE}개여야 합니다"
    }
}
