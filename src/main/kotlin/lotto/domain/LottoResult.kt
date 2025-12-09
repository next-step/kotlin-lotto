package lotto.domain

import java.util.EnumMap

class LottoResult(
    val winLotto: Lotto,
    private val bonusBall: BonusBall,
    val lottoTicket: LottoTicket,
) {
    val matchMap: EnumMap<Rank, Int> = EnumMap(Rank::class.java)
    var rateOfReturn = 0.0

    init {
        match()
        rateOfReturn()
    }

    private fun rateOfReturn() {
        val totalMoney = lottoTicket.money
        val winningMoney = matchMap.entries.sumOf { entry -> entry.key.winningMoney * entry.value }
        rateOfReturn = winningMoney.toDouble() / totalMoney.price
    }

    private fun match() {
        lottoTicket.lottos.forEach { lotto ->
            val matchCount = matchCount(lotto)
            val hasBonus = bonusBall.matches(lotto)
            val rank = Rank.valueOf(matchCount, hasBonus)
            matchMap[rank] = matchMap.getOrDefault(rank, 0) + 1
        }
    }

    private fun matchCount(lotto: Lotto): Int {
        return winLotto.numbers.intersect(lotto.numbers.toSet()).size
    }
}
