package lotto.ui

import lotto.domain.LottoResult
import lotto.domain.LottoList

object OutputUI {

    fun drawPurchaseMessage(count: Int) {
        println("${count}개를 구매했습니다.")
    }

    fun drawLotto(lottoList: LottoList) {
        lottoList.forEach {
            println("[$it]")
        }
    }

    fun drawWinningResult(result: LottoResult) {
        println("당첨 통계")
        println("---------")
        result.forEach { grade, count ->
            "${grade.matchCount}개 일치 (${grade.reward})- ${count}개"
        }
    }

    fun drawWinningRevenueRate(rate: Float) {
        println("총 수익률은 %.2f 입니다.".format(rate))
    }
}
