package lotto.domain

import lotto.domain.JackpotLevel.Companion.findMatchingLevel

class LottoWinning(private val jackpotNumbers: Lotto) {

    fun checkLottoWinning(lottoList: List<Lotto>): List<JackpotLevel> {
        return lottoList.map {
            val matchNumberCount = it.getMatchLottoCount(jackpotNumbers)
            findMatchingLevel(matchNumberCount)
        }
    }
}
