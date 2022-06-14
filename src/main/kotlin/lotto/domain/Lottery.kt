package lotto.domain

import lotto.vo.LotteryNumber

class Lottery(private val numbers: LotteryNumberSet) {

    override fun toString(): String = "$numbers"

    fun contains(lotteryNumber: LotteryNumber) = numbers.contains(lotteryNumber)

    companion object {

        const val PRICE = 1_000
    }
}
