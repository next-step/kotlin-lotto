package lotto.domain

import lotto.domain.entity.user.Lotto
import lotto.domain.entity.winning.BonusNumber
import lotto.domain.entity.winning.WinningLotto
import lotto.domain.enums.PrizeType

object LottoMatch {

    private const val LOTTO_MATCH_UP_COUNT = 1
    private const val DEFAULT_VALUE = 0

    fun match(userLottoNumbers: List<Lotto>, winningLotto: WinningLotto, bonusNumber: BonusNumber): Map<PrizeType, Int> {

        val lottoPrize = mutableMapOf<PrizeType, Int>()

        for (lotto in userLottoNumbers) {
            val matchCount = lotto.getLottoNumber()
                .filter { winningLotto.containsLottoNumber(it) }
                .size

            val bonusMatch = lotto.getLottoNumber()
                .find { it == bonusNumber.lottoNumber } != null

            val prizeType = PrizeType.findPrize(matchCount, bonusMatch)

            lottoPrize[prizeType] = lottoPrize.getOrDefault(prizeType, DEFAULT_VALUE) + LOTTO_MATCH_UP_COUNT
        }

        return lottoPrize
    }
}
