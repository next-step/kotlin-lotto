package lotto.ui

import lotto.domain.Lotto
import lotto.domain.LottoLine
import lotto.domain.LottoResult
import lotto.domain.Rank

object ResultView {
    private const val COMMA_SEPARATOR = ", "

    fun printLotto(lotto: Lotto) {
        lotto.lines.forEach { printLine(it) }
        println()
    }

    private fun printLine(
        line: LottoLine,
        prefix: String = "[",
        suffix: String = "]",
    ) {
        val numbers = line.numbers.map { it.value }
        val text = prefix + numbers.joinToString(COMMA_SEPARATOR) + suffix
        println(text)
    }

    fun printResult(result: LottoResult) {
        println("\n당첨 통계\n---------")
        Rank.entries.reversed().forEach { printResultByRank(it, result.get(it)) }
    }

    private fun printResultByRank(
        rank: Rank,
        count: Int,
    ) {
        if (rank == Rank.MISS) {
            return
        }
        println("${rank.count}개 일치 (${rank.prize}원)- ${count}개")
    }
}
