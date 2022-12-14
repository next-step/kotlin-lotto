package lotto.domain.lotto.result

import lotto.domain.lotto.benefit.LottoBenefitLevel

class LottoResultMap(
    lottoTicketResultList: List<LottoTicketResult>
)  {

    private val winningCountMap: Map<LottoBenefitLevel, Int> =
        lottoTicketResultList
            .groupBy { LottoBenefitLevel.of(it) }
            .filterKeys { it.isPositiveBenefitLevel() }
            .mapValues { it.value.size }

    fun winningCount(lottoBenefitLevel: LottoBenefitLevel): Int =
        winningCountMap[lottoBenefitLevel] ?: 0
}
