package lotto.domain

import lotto.LottoUtils.luckyNumbers

class Lottos(private val lottos: List<Lotto>) {

    fun matchCounts(): List<Int> {
        return lottos.map { it.getMatchCount(luckyNumbers) }
    }

    override fun toString(): String {
        return lottos.joinToString("\r\n")
    }
}
