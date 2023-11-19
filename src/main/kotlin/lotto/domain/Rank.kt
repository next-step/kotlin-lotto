package lotto.domain

import java.util.function.BiPredicate

enum class Rank(val isMatched: BiPredicate<Int, Boolean>, prize: Int) {
    FIRST({ count, _ -> count == 6 }, 2_000_000_000),
    SECOND({ count, hasBonusNumber -> count == 5 && hasBonusNumber }, 30_000_000),
    THIRD({ count, hasBonsNumber -> count == 5 && !hasBonsNumber }, 1_500_000),
    FOURTH({ count, _ -> count == 4 }, 50_000),
    FIFTH({ count, _ -> count == 3 }, 5_000),
    NOTHING({ count, _ -> count < 3 }, 0),
    ;

    val prize = prize.toBigDecimal()

    companion object {
        fun find(matchedCount: Int, hasBonusNumber: Boolean): Rank {
            return values().first { it.isMatched.test(matchedCount, hasBonusNumber) }
        }
    }
}
