package lotto.domain

import java.util.EnumMap

class LottoResult(
    val winLotto: WinLotto,
    private val bonusBallLotto: BonusBallLotto,
    val lottoTicket: LottoTicket,
) {
    val matchMap: EnumMap<Rank, Int> = EnumMap(Rank::class.java)
    var rateOfReturn = 0.0

    fun process() {
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
            val matchCount = winLotto.matchCount(lotto)
            val hasBonus = bonusBallLotto.matches(lotto)
            val rank = Rank.valueOf(matchCount, hasBonus)
            matchMap[rank] = matchMap.getOrDefault(rank, 0) + 1
        }
    }

    fun printResult() {
        println(
            """
당첨 통계
${
                Rank.entries.filter { it != Rank.MISS }
                    .sorted()
                    .reversed()
                    .joinToString("\n") {
                        val matchDescription =
                            when (it) {
                                Rank.SECOND -> "${it.countOfMatch}개 일치, 보너스 볼 일치"
                                else -> "${it.countOfMatch}개 일치"
                            }
                        "$matchDescription (${it.winningMoney}원)- ${
                            matchMap.getOrDefault(it, 0)
                        }개"
                    }
            }
총 수익률은 %.2f 입니다."
"""
                .trimIndent()
                .format(rateOfReturn),
        )
    }
}
