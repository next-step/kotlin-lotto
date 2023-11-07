package lotto.view

import lotto.domain.LottoPrize
import lotto.domain.LottoResult
import lotto.domain.LottoResultMachine.calculateYield

object OutputView {
    fun printLottoResult(lottoResultMap: Map<LottoPrize, List<LottoResult>>) {
        println("당첨 통계")
        println("---------")
        LottoPrize.values().forEach { prize ->
            if (prize == LottoPrize.MISS) return@forEach
            println("${prize.matchCount}개 일치 (${prize.prizeMoney}원) - ${lottoResultMap[prize]?.size ?: 0}개")
        }
        println("총 수익률은 ${calculateYield(lottoResultMap)}입니다.")
    }
}
