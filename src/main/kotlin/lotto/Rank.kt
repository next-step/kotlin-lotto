package lotto

import java.util.function.BiPredicate

enum class Rank(val isMatched: BiPredicate<Int, Boolean>, prize: Int) {
    FIRST({ count, _ -> count == 6 }, 2000000000),
    SECOND({ count, hasBonusNumber -> count == 5 && hasBonusNumber }, 30000000),
    THIRD({ count, hasBonsNumber -> count == 5 && !hasBonsNumber }, 1500000),
    FOURTH({ count, _ -> count == 4 }, 50000),
    FIFTH({ count, _ -> count == 3 }, 5000),
    NOTHING({ count, _ -> count < 3 }, 0),
    ;

    val prize = prize.toBigDecimal()

    companion object {
        fun find(matchedCount: Int, hasBonusNumber: Boolean): Rank {
            return values().first { it.isMatched.test(matchedCount, hasBonusNumber) }
        }
    }
}
