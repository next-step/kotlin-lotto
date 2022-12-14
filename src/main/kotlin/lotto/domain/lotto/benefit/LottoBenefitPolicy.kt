package lotto.domain.lotto.benefit

import lotto.domain.lotto.price.LottoCost
import lotto.domain.lotto.result.LottoResultMap
import java.util.*

class LottoBenefitPolicy {

    fun benefit(resultMap: LottoResultMap, lottoCost: LottoCost): LottoBenefit {
        val totalBenefit = positiveBenefitLevelSet().sumOf { lottoBenefitLevel ->
            resultMap.winningCount(lottoBenefitLevel) * lottoBenefitLevel.benefitPerTicket
        }

        return LottoBenefit(totalBenefit, lottoCost)
    }

    private fun positiveBenefitLevelSet(): EnumSet<LottoBenefitLevel> =
        LottoBenefitLevel.positiveBenefitLevelSet()
}
