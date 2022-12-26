package lotto.model

import java.math.BigDecimal

class LottoPrizes private constructor(private val value: List<LottoPrize>) {
    fun getTotalWinningAmount(): BigDecimal {
        return value.map { it.winningAmount }.reduce(BigDecimal::add)
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
