package lotto.view

import lotto.domain.lotto.benefit.LottoBenefit
import lotto.domain.lotto.benefit.LottoBenefitLevel
import lotto.domain.lotto.result.LottoResult
import lotto.domain.lotto.result.LottoResultMap
import kotlin.math.round

class LottoResultView {
    fun printLottoResultView(lottoResult: LottoResult) {
        println("\n당첨 통계")
        println("---------")

        printLottoResultMatchCountMap(lottoResult.lottoResultMap)
        printLottoBenefit(lottoResult.lottoBenefit)
    }

    private fun printLottoResultMatchCountMap(lottoResultMap: LottoResultMap) {
        LottoBenefitLevel.positiveBenefitLevelSet()
            .sortedWith(compareBy({ it.matchCount }, { it.isBonus }))
            .forEach { benefitLevel ->
                println("${benefitLevel.description()}- ${lottoResultMap.winningCount(benefitLevel)}개")
            }
    }

    private fun printLottoBenefit(lottoBenefit: LottoBenefit) {
        println("총 수익률은 ${round(lottoBenefit.profit * 100) / 100}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }
}
