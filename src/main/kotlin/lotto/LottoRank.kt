package lotto

import java.lang.IllegalArgumentException

enum class LottoRank(
    private val matchCount: Int,
    private val money: Int,
) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FORTH(3, 5_000),
    ;

    companion object {
        fun from(matchCount: Int): LottoRank {
            return LottoRank.values().find { it.matchCount == matchCount }
                ?: throw IllegalArgumentException()
        }
    }
}
