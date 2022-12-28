package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoRank
import java.math.BigDecimal

object OutputView {
    fun writeLottos(manualCount: Int, lottos: List<Lotto>) {
        println("수동으로 ${manualCount}장, 자동으로 ${lottos.size - manualCount}개를 구매했습니다.")
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
            .sortedBy { it.winning }
            .forEach { println("${it.matchCount}개 일치${if (it == LottoRank.SECOND) ", 보너스 볼 일치" else " "}(${it.winning}원)- ${countByLottoRank[it]}개") }
        println("총 수익률은 ${profit}입니다.")
    }
}
