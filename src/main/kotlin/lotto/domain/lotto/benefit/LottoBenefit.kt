package lotto.domain.lotto.benefit

import lotto.domain.lotto.price.LottoCost

data class LottoBenefit(val benefit: Int, val lottoCost: LottoCost) {

    val profit: Double
        get() = benefit.toDouble() / lottoCost.ticketCost
}
