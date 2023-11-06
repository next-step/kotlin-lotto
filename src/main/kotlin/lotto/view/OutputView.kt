package lotto.view

import lotto.domain.Prize
import lotto.domain.PrizeEvaluator.calculateROI

object OutputView {

    fun writeROI(totalPrize: Prize, inputPrice: Int) {

        when (val roi = calculateROI(totalPrize, inputPrice)) {
            in 0.0..1.0 -> println("총 수익률은 $roi 입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임) \n ")
            else -> println("총 수익률은 $roi 로 이익입니다. \n ")
        }
    }

    fun writeSingleOutput(message: String) {
        println(message)
    }
}
