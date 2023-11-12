package lotto.domain

import lotto.domain.JackpotLevel.Companion.findMatchingLevel

class LottoWinning(private val jackpotNumbers: Lotto) {

    fun checkLottoWinning(lottoList: List<Lotto>, bonusNumber: Int): List<JackpotLevel> {
        return lottoList.map {
            val matchNumberCount = it.getMatchLottoCount(jackpotNumbers)
            val matchBonus = it.getMatchBonusResult(LottoNumber(bonusNumber))
            findMatchingLevel(matchNumberCount, matchBonus)
        }
    }
}
