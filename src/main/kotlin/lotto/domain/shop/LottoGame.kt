package lotto.domain.shop

import lotto.domain.analysis.LottoWinRank
import lotto.domain.analysis.MatchCondition
import lotto.domain.lottonumber.LottoNumbers
import lotto.domain.lottonumber.WinLottoNumbers

@JvmInline
value class LottoGame(val lottoNumbers: LottoNumbers) {

    fun matchOrNull(lastWeekLottoNumbers: WinLottoNumbers): LottoWinRank? {
        return LottoWinRank.findOrNull(
            MatchCondition(
                matchSuccessCount = lastWeekLottoNumbers.matchCount(lottoNumbers),
                isMatchedBonus = lastWeekLottoNumbers.matchBonus(lottoNumbers)
            )
        )
    }
}
