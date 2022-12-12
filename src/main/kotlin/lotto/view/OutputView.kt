package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoRank
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

    fun writeResult(countByLottoRank: Map<LottoRank, Int>, profit: BigDecimal) {
        println("당첨 통계")
        println("---------")
        countByLottoRank.keys
            .filter { it != LottoRank.NONE }
            .sortedBy { it.matchCount }
            .forEach { println("${it.matchCount}개 일치 (${it.winning}원)- ${countByLottoRank[it]}개") }
        println("총 수익률은 ${profit}입니다.")
    }
}
