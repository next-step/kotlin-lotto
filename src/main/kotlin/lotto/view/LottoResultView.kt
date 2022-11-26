package lotto.view

import lotto.domain.lotto.benefit.LottoBenefit
import lotto.domain.lotto.benefit.LottoBenefitPolicy
import lotto.domain.lotto.result.LottoResult
import kotlin.math.round

class LottoResultView {
    fun printLottoResultView(lottoResult: LottoResult) {
        println("당첨 통계")
        println("---------")

        printLottoResultCountMap(lottoResult.lottoResultCountMap)
        printLottoBenefit(lottoResult.lottoBenefit)
    }

    private fun printLottoResultCountMap(resultCountMap: Map<Int, Int>) {
        for ((benefitKey, benefitValue) in LottoBenefitPolicy.benefitPolicy) {
            println("${benefitKey}개 일치 (${benefitValue}원)- ${resultCountMap.getOrDefault(benefitKey, 0)}개")
        }
    }

    private fun printLottoBenefit(lottoBenefit: LottoBenefit) {
        println("총 수익률은 ${round(lottoBenefit.profit * 100) / 100}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }
}
