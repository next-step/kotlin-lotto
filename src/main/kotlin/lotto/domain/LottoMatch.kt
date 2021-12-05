package lotto.domain

import lotto.domain.entity.user.Lotto
import lotto.domain.entity.winning.BonusNumber
import lotto.domain.entity.winning.WinningLotto
import lotto.domain.enums.PrizeType

object LottoMatch {

    private const val LOTTO_MATCH_UP_COUNT = 1
    private const val DEFAULT_VALUE = 0

    fun match(userLottoNumbers: List<Lotto>, winningLotto: WinningLotto, bonusNumber: BonusNumber): Map<PrizeType, Int> {

        val lottoPrize = mutableMapOf(
            (PrizeType.FIRST_PLACE to DEFAULT_VALUE),
            (PrizeType.SECOND_PLACE to DEFAULT_VALUE),
            (PrizeType.THIRD_PLACE to DEFAULT_VALUE),
            (PrizeType.FOURTH_PLACE to DEFAULT_VALUE),
            (PrizeType.FIFTH_PLACE to DEFAULT_VALUE),
        )

        for (lotto in userLottoNumbers) {
            val matchCount = lotto.getLottoNumber()
                .filter { winningLotto.containsLottoNumber(it) }
                .size

            val bonusMatch = lotto.getLottoNumber()
                .find { it == bonusNumber.lottoNumber } != null

            matchCountGreaterThanEqualLottoMinMatch(matchCount, lottoPrize, bonusMatch)
        }

        return lottoPrize
    }

    private fun matchCountGreaterThanEqualLottoMinMatch(matchCount: Int, lottoPrize: MutableMap<PrizeType, Int>, bonusMatch: Boolean) {
        val prizeType: PrizeType = PrizeType.findPrize(matchCount, bonusMatch)
        lottoPrize[prizeType] = nullOrPlus(lottoPrize[prizeType])
    }

    private fun nullOrPlus(number: Int?): Int {
        if (number == null) {
            return 0
        }
        return number + 1
    }
}
