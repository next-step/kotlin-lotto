package lotto.domain

import lotto.domain.JackpotLevel.Companion.findMatchingLevel

class LottoResult {

    fun splitLottoNumber(inputNumber: String, delimiters: String = ", "): List<Int> {
        return inputNumber.split(delimiters).map { it.toInt() }
    }

    fun findJackpotLotto(jackpotNumbers: List<Int>, lottoList: List<Lotto>): List<JackpotLevel> {
        return lottoList.map {
            val matchNumberCount = it.getMatchLottoCount(jackpotNumbers)
            findMatchingLevel(matchNumberCount)
        }
    }
}
