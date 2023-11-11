package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoPrize
import lotto.domain.LottoResult

object OutputView {
    fun printLottoResult(lottoResultMap: Map<LottoPrize, List<LottoResult>>) {
        println("당첨 통계")
        println("---------")
        LottoPrize.values().forEach { prize ->
            if (prize == LottoPrize.MISS) return@forEach
            println("${prize.matchCount}개 일치 (${prize.prizeMoney}원) - ${lottoResultMap[prize]?.size ?: 0}개")
        }
//        println("총 수익률은 ${calculateYield(lottoResultMap)}입니다.")
    }

    fun buyLotto(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach { println(it.numbers) }
        println()
    }
}
