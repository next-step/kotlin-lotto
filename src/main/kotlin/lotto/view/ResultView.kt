package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoResult
import lotto.domain.Rank
import lotto.domain.WinningResult

object ResultView {
    fun printCreatedLottos(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach { println(it.numbers) }
        println()
    }

    fun printResult(result: WinningResult) {
        println("당첨 통계")
        println("-------")
        result.winningMatchCounts.forEach { data ->
            printLottoResult(data)
        }
        println("총 수익률은 ${result.rate}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }

    private fun printLottoResult(lottoResult: LottoResult) {
        if (lottoResult.rank == Rank.SECOND) {
            println("${lottoResult.rank.matchCount}개 일치, 보너스 볼 일치 (${lottoResult.rank.prizeAmount}원) - ${lottoResult.totalCount}")
        } else {
            println("${lottoResult.rank.matchCount}개 일치 (${lottoResult.rank.prizeAmount}원) - ${lottoResult.totalCount}")
        }
    }
}
