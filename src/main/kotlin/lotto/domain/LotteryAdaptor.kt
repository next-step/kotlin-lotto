package lotto.domain

import lotto.model.LottoErrorCode

abstract class LotteryAdaptor(private val lottoNumbers: Set<LottoNumber>) {

    init {
        val size = lottoNumbers.size

        require(value = size == ALLOW_LOTTO_NUMBER_COUNT) {
            LottoErrorCode.INVALID_LOTTERY_NUMBER.message("$size $ALLOW_LOTTO_NUMBER_COUNT")
        }
    }

    fun correctLottery(otherLottery: LotteryAdaptor, bonusBall: LottoNumber): LottoRank = LottoRank.valueOf(
        lottoMatchResult = correctMatchResult(
            otherLottery = otherLottery,
            bonusBall = bonusBall,
        ),
    )

    private fun correctMatchResult(
        otherLottery: LotteryAdaptor,
        bonusBall: LottoNumber,
    ): LottoMatchResult {
        val countOfMatch = lottoNumbers.count { it in otherLottery.lottoNumbers }

        return LottoMatchResult(
            countOfMatch = countOfMatch,
            mustBonusMatch = LottoRank.hasBonusMatch(countOfMatch = countOfMatch) && bonusBall in lottoNumbers,
        )
    }

    override fun toString(): String = lottoNumbers.toString()

    companion object {
        internal const val ALLOW_LOTTO_NUMBER_COUNT: Int = 6
        internal const val LOTTERY_PRICE: Double = 1000.0
    }
}
