package lotto.ui

import lotto.domain.Grade
import lotto.domain.LottoList
import lotto.domain.LottoResult

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
        listOf(Grade.Fourth, Grade.Third, Grade.Second, Grade.First).forEach {
            val matchedCount = result.getMatchedCount(it)
            println("${it.matchCount}개 일치 (${it.reward})- ${matchedCount}개")
        }
    }

    fun drawWinningRevenueRate(rate: Float) {
        println("총 수익률은 %.2f 입니다.".format(rate))
    }
}
