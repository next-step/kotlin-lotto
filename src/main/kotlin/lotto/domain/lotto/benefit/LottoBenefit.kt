package lotto.domain.lotto.benefit

import lotto.domain.lotto.price.LottoCost

data class LottoBenefit(
    val benefit: Int,
    val lottoCost: LottoCost
) {

    val profit: Double
        get() = benefit.toDouble() / lottoCost.ticketCost

    init {
        require(benefit >= 0) {
            "Benefit should be greater and equal than zero"
        }
    }
}
