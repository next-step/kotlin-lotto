package lotto

import java.lang.IllegalArgumentException

enum class LottoResult(
    val matchCount: Int,
    val winningMoney: Int
) {
    MATCH_THREE_NUMBERS(3, 5000),
    MATCH_FOUR_NUMBERS(4, 50000),
    MATCH_FIVE_NUMBERS(5, 1500000),
    MATCH_SIX_NUMBERS(6, 2000000000);

    companion object{
        fun fromMatchCount(count: Int) : LottoResult{
            return values().first { it.matchCount == count}
        }
    }
}