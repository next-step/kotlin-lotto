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
        val message = buildString {
            append("당첨 통계\n")
            append("---------\n")
            listOf(Grade.Five, Grade.Fourth, Grade.Third, Grade.Second, Grade.First).forEach {
                append("${it.matchCount}개 일치")
                if (it.matchBonus) append(", 보너스 볼 일치")
                append(" (${it.reward}원)- ")
                append("${result.getMatchedCount(it)}개\n")
            }
        }

        println(message)
    }

    fun drawWinningRevenueRate(rate: Float) {
        println("총 수익률은 %.2f 입니다.".format(rate))
    }
}
