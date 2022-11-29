package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoMatch
import lotto.domain.Winning
import java.math.BigDecimal

object OutputView {
    fun writeLottos(lottos: List<Lotto>) {
        lottos.forEach {
            println(
                it.numbers
                    .map { number -> number.value }
                    .sorted()
            )
        }
    }

    fun writeResult(countByLottoMatch: Map<LottoMatch, Int>, profit: BigDecimal) {
        println("당첨 통계")
        println("---------")
        countByLottoMatch.keys
            .filter { it != LottoMatch.NONE }
            .sortedBy { it.matchCount }
            .forEach { println("${it.matchCount}개 일치 (${Winning.of(it).money}원)- ${countByLottoMatch[it]}개") }
        println("총 수익률은 ${profit}입니다.")
    }
}
