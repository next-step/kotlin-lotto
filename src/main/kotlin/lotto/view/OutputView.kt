package lotto.view

import lotto.domain.LottoMatch
import lotto.domain.Winning
import java.math.BigDecimal

object OutputView {
    fun writeLottos(lottos: List<List<Int>>) {
        lottos.forEach {
            println(it)
        }
    }

    fun writeResult(countByLottoMatch: Map<LottoMatch, Int>, profit: BigDecimal) {
        println("당첨 통계")
        println("---------")
        countByLottoMatch.keys
            .filter { it != LottoMatch.NONE }
            .sortedBy { it.matchCount }
            .forEach { println("${it.matchCount}개 일치 ${Winning.of(it).money}원 - ${countByLottoMatch[it]}") }
        println("총 수익률은 ${profit}입니다.")
    }
}
