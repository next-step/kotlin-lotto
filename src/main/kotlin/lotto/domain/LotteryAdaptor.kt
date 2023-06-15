package lotto.domain

import lotto.model.LottoErrorCode

abstract class LotteryAdaptor(val lottoNumbers: Set<LottoNumber>) {

    init {
        val size = lottoNumbers.size

        require(value = size == ALLOW_LOTTO_NUMBER_COUNT) {
            LottoErrorCode.INVALID_LOTTERY_NUMBER.message("$size $ALLOW_LOTTO_NUMBER_COUNT")
        }
    }

    fun correctLottery(winningLottery: WinningLottery): LottoRank = LottoRank.valueOf(
        lottoMatchResult = correctMatchResult(
            winningLottery = winningLottery,
        ),
    )

    private fun correctMatchResult(
        winningLottery: WinningLottery,
    ): LottoMatchResult {
        val countOfMatch = lottoNumbers.count { it in winningLottery.lottoNumbers }
        val mustBonusMatch =
            LottoRank.hasBonusMatch(countOfMatch = countOfMatch) && winningLottery.bonusBall in lottoNumbers

        return LottoMatchResult(
            countOfMatch = countOfMatch,
            mustBonusMatch = mustBonusMatch,
        )
    }

    override fun toString(): String = lottoNumbers.toString()

    companion object {
        internal const val ALLOW_LOTTO_NUMBER_COUNT: Int = 6
        internal const val LOTTERY_PRICE: Double = 1000.0
    }
}
