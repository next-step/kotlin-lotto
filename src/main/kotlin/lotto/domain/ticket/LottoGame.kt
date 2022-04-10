package lotto.domain.ticket

import lotto.domain.ticket.lottery.LotteryNumbers

@JvmInline
value class LottoGame private constructor(
    private val _lotteryNumbers: LotteryNumbers
) {
    val value: List<Int>
        get() = _lotteryNumbers.values

    override fun toString(): String {
        return value.toString()
    }

    companion object {
        fun quickPick(): LottoGame {
            return LottoGame(LotteryNumbers.quickPick())
        }
    }
}
