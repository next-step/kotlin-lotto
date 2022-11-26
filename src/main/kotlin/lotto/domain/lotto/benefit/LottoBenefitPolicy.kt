package lotto.domain.lotto.benefit

import lotto.domain.lotto.price.LottoCost
import lotto.domain.lotto.result.LottoResultCountMap

class LottoBenefitPolicy {

    fun benefit(resultCountMap: LottoResultCountMap, lottoCost: LottoCost): LottoBenefit {
        var result = 0

        for ((count, value) in resultCountMap) {
            result += benefitPolicy.getOrDefault(count, 0) * value
        }

        return LottoBenefit(result, lottoCost)
    }

    companion object {
        val benefitPolicy: Map<Int, Int> = mapOf(
            3 to 5000,
            4 to 50000,
            5 to 1500000,
            6 to 2000000000
        )
    }
}
