package lotto.domain

enum class Rank(val matchCount: Int, val winningMoney: Int) {
    FIRST(6, 2_000_000_000),
    THREE(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(-1, 0)
    ;

    companion object {
        fun from(matchCount: Int) : Rank {
            return when (matchCount) {
                FIRST.matchCount -> FIRST
                THREE.matchCount -> THREE
                FOURTH.matchCount -> FOURTH
                FIFTH.matchCount -> FIFTH
                else -> NONE
            }
        }
    }
}

