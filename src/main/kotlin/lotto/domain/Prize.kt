package lotto.domain

/**
 * 클래스에 대한 설명을 적어주세요.
 * Created by Jaesungchi on 2022.05.25..
 */

enum class Prize(val matchCount: Int, val reward: Int) {
    LOSER(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 500_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000)
    ;

    companion object {
        fun of(matchCount: Int, isCorrectBonus: Boolean): Prize {
            return values().find {
                if (isCorrectBonus && matchCount == SECOND.matchCount)
                    return SECOND
                it.matchCount == matchCount
            } ?: LOSER
        }
    }
}
