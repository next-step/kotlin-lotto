package lotto.domain

import lotto.domain.JackpotLevel.Companion.findMatchingLevel

class LottoWinning(private val jackpotNumbers: Lotto, private val bonusNumber: LottoNumber) {

    fun checkLottoWinning(lottoList: List<Lotto>): List<JackpotLevel> {
        return lottoList.map {
            val matchNumberCount = it.countMatchingNumbers(jackpotNumbers)
            val matchBonus = it.checkBonusNumberMatch(bonusNumber)
            findMatchingLevel(matchNumberCount, matchBonus)
        }
    }
}
