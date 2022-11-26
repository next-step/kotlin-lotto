package lotto.view

import lotto.domain.lotto.benefit.LottoBenefit
import lotto.domain.lotto.benefit.LottoBenefitLevel
import lotto.domain.lotto.result.LottoResult
import lotto.domain.lotto.result.LottoResultMatchCountMap
import kotlin.math.round

class LottoResultView {
    fun printLottoResultView(lottoResult: LottoResult) {
        println("\n당첨 통계")
        println("---------")

        printLottoResultMatchCountMap(lottoResult.lottoResultMatchCountMap)
        printLottoBenefit(lottoResult.lottoBenefit)
    }

    private fun printLottoResultMatchCountMap(lottoResultMatchCountMap: LottoResultMatchCountMap) {
        for (lottoBenefitLevel in LottoBenefitLevel.values().sortedBy { it.matchCount }) {
            println("${lottoBenefitLevel.description()}- ${lottoResultMatchCountMap[lottoBenefitLevel.matchCount]}개")
        }
    }

    private fun printLottoBenefit(lottoBenefit: LottoBenefit) {
        println("총 수익률은 ${round(lottoBenefit.profit * 100) / 100}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }
}
