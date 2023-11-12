package lotto.domain

import lotto.domain.JackpotLevel.Companion.findMatchingLevel

class LottoWinning(private val jackpotNumbers: Lotto) {

    fun checkLottoWinning(lottoList: List<Lotto>, bonusNumber: LottoNumber): List<JackpotLevel> {
        return lottoList.map {
            val matchNumberCount = it.getMatchLottoCount(jackpotNumbers)
            val matchBonus = it.getMatchBonusResult(bonusNumber)
            findMatchingLevel(matchNumberCount, matchBonus)
        }
    }
}
