package lotto.domain

import lotto.domain.JackpotLevel.Companion.findMatchingLevel

class LottoWinning {

    fun splitLottoNumber(inputNumber: String, delimiters: String = ", "): Lotto {
        return Lotto(inputNumber.split(delimiters).map { it.toInt() })
    }

    fun checkLottoWinning(jackpotNumbers: Lotto, lottoList: List<Lotto>): List<JackpotLevel> {
        return lottoList.map {
            val matchNumberCount = it.getMatchLottoCount(jackpotNumbers)
            findMatchingLevel(matchNumberCount)
        }
    }
}
