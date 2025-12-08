package lotto

import java.util.EnumMap

class LottoResult(val winLotto: WinLotto, val lottos: List<Lotto>) {
    val matchMap: EnumMap<Rank, Int> = EnumMap(Rank::class.java)
    var rateOfReturn = 0.0

    fun process() {
        match()
        rateOfReturn()
    }

    private fun match() {
        lottos.forEach { lotto ->
            val rank = Rank.valueOf(winLotto.matchCount(lotto), winLotto.matchBonusBall(lotto))
            matchMap[rank] = matchMap.getOrDefault(rank, 0) + 1
        }
    }

    private fun rateOfReturn() {
        val totalMoney = lottos.size * LottoMoney.LOTTO_UNIT_PRICE
        val winningMoney = matchMap.entries.sumOf { (rank, count) -> rank.winningMoney * count }
        rateOfReturn = winningMoney.toDouble() / totalMoney
    }

    fun printResult() {
        println(
"""
당첨 통계
${Rank.entries.filter { it != Rank.MISS }
                .sorted()
                .reversed()
                .joinToString("\n") { "${it.countOfMatch}개 일치 (${it.winningMoney}원)- ${matchMap.getOrDefault(it, 0)}개" }}
총 수익률은 %.2f 입니다."
"""
                .trimIndent()
                .format(rateOfReturn),
        )
    }
}
