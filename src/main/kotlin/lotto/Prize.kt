package lotto

import java.util.function.BiPredicate

enum class Prize(val isMatched: BiPredicate<Int, Boolean>) {
    FIRST({ count, _ -> count == 6 }),
    SECOND({ count, hasBonusNumber -> count == 5 && hasBonusNumber }),
    THIRD({ count, hasBonsNumber -> count == 5 && !hasBonsNumber }),
    FOURTH({ count, _ -> count == 4 }),
    FIFTH({ count, _ -> count == 3 }),
    NOTHING({ count, _ -> count < 3 }),
    ;

    companion object {
        fun find(matchedCount: Int, hasBonusNumber: Boolean): Prize {
            return values().first { it.isMatched.test(matchedCount, hasBonusNumber) }
        }
    }
}
