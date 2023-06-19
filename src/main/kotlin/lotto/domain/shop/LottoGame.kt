package lotto.domain.shop

import lotto.domain.analysis.LottoWinRank
import lotto.domain.analysis.MatchCondition
import lotto.domain.lottonumber.LottoNumbers
import lotto.domain.lottonumber.WinLottoNumbers
import math.PositiveNumber

@JvmInline
value class LottoGame(val lottoNumbers: LottoNumbers) {

    fun matchOrNull(lastWeekLottoNumbers: WinLottoNumbers): LottoWinRank? {
        val lastWeekLottoNumberSet = lastWeekLottoNumbers.lottoNumbers.toSet()
        val matchSuccessCount = lottoNumbers.value.count { lastWeekLottoNumberSet.contains(it) }
        val isMatchedBonus = lottoNumbers.value.contains(lastWeekLottoNumbers.bonusNumber)
        return LottoWinRank.findOrNull(
            MatchCondition(
                matchSuccessCount = PositiveNumber(matchSuccessCount),
                isMatchedBonus = isMatchedBonus
            )
        )
    }
}
