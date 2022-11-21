package lotto.domain

import lotto.util.ErrorCode

class LottoStatistics(
    winningLottoNumbers: String
) {
    private var winningLotto: Lotto

    init {
        val numbers = validateWinningLottoNumbers(winningLottoNumbers)

        require(numbers.distinct().count() == LottoGenerator.LOTTO_NUMBER_COUNT) {
            ErrorCode.LOTTO_NUMBERS_COUNT_EXCEPTION.errorMessage
        }

        winningLotto = Lotto(numbers)
    }

    private fun validateWinningLottoNumbers(number: String): List<Int> {
        require(number.matches(winningLottoNumbersRegex)) {
            ErrorCode.LOTTO_NUMBERS_INPUT_FORMAT_EXCEPTION.errorMessage
        }
        return number
            .split(SEPARATOR)
            .mapNotNull {
                it.trim()
                    .toIntOrNull()
            }
    }

    fun getWinningStatistics(lottoList: List<Lotto>): List<LottoMatch> {
        val lottoMatchResult = LottoMatchResult()
        lottoList.forEach { lotto ->
            val matchCount = winningLotto.getMatchCount(lotto)
            lottoMatchResult.setMatchResult(matchCount)
        }
        return lottoMatchResult.getMatchResult()
    }

    fun getProfit(totalPrice: Long, lottMatchList: List<LottoMatch>): Double {
        // 총 이득
        val totalReward = lottMatchList.sumOf { lottoMatch ->
            lottoMatch.matchCount * lottoMatch.reward
        }

        val profit = totalReward / totalPrice.toDouble()

        return (profit * DIGIT_NUMBER).toInt() / DIGIT_NUMBER
    }

    fun isProfitable(profit: Double) = profit >= STANDARD_PROFIT_RATIO

    companion object {
        private val winningLottoNumbersRegex = """^[0-9,\s]*$""".toRegex()
        private const val SEPARATOR = ","
        private const val DIGIT_NUMBER = 100.0
        const val STANDARD_PROFIT_RATIO = 1
    }
}
