package lotto.model

class LottoPrizes private constructor(private val value: List<LottoPrize>) {
    fun getTotalWinningAmount(): Money {
        return value.map { it.winningAmount }.reduce(Money::plus)
    }

    fun getCountOf(prize: LottoPrize): Int {
        return value.count { it == prize }
    }

    companion object {
        fun of(value: List<LottoPrize>): LottoPrizes {
            return LottoPrizes(value)
        }

        fun of(vararg value: LottoPrize): LottoPrizes {
            return of(value.toList())
        }

        fun of(lottos: Lottos, winningNumbers: WinningNumbers): LottoPrizes {
            return of(lottos.map { winningNumbers.prizeOf(it) })
        }
    }
}
