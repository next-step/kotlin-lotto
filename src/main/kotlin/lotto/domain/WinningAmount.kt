package lotto.domain

import java.lang.IllegalArgumentException

enum class WinningAmount(
    private val count: Int,
    val amount: Long,
) {
    ZERO(0, 0L),
    ONE(1, 0L),
    TWO(2, 0L),
    THREE(3, 5000L),
    FOUR(4, 50000L),
    FIVE(5, 1500000L),
    SIX(6, 2000000000L);

    companion object {
        fun from(count: Int): WinningAmount {
            return values().find { it.count == count } ?: throw IllegalArgumentException("존재하지 않는 WinningAmount 에요.")
        }
    }
}
