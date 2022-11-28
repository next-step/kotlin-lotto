package lotto.domain.lotto.benefit

import lotto.domain.lotto.price.LottoCost
import lotto.domain.lotto.result.LottoResultMatchCountMap

class LottoBenefitPolicy {

    fun benefit(resultCountMap: LottoResultMatchCountMap, lottoCost: LottoCost): LottoBenefit {
        val result = resultCountMap.map { (matchCount, ticketCount) ->
            LottoBenefitLevel.benefitPerTicketOf(matchCount) * ticketCount
        }.sum()

        return LottoBenefit(result, lottoCost)
    }
}
