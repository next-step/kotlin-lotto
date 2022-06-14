package lotto.ui

import lotto.domain.Grade
import lotto.domain.LottoList
import lotto.domain.LottoResult
import lotto.domain.OrderSheet

object OutputUI {

    fun drawPurchaseMessage(orderSheet: OrderSheet) {
        println("수동으로 ${orderSheet.manualCount}장, 자동으로 ${orderSheet.autoCount}개를 구매했습니다.")
    }

    fun drawManualInputRequest() {
        println("수동으로 구매할 번호를 입력해 주세요.")
    }

    fun drawErrorMessage(message: String) {
        println(message)
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
