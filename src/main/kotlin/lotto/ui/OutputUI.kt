package lotto.ui

import lotto.domain.GradeInfos
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

    fun drawWinningResult(result: GradeInfos) {
        println("당첨 통계")
        println("---------")
        result.forEach { grade, count ->
            "${grade.matchCount}개 일치 (${grade.reward})- ${count}개"
        }
    }
}
