package lotto.model

/**
 * 클래스에 대한 설명을 적어주세요.
 * Created by Jaesungchi on 2022.05.25..
 */

enum class Prize(val matchCount: Int, val reward: Int) {
    FIRST_PLACE(6, 2000000000),
    SECOND_PLACE(5, 1500000),
    THIRD_PLACE(4, 500000),
    FOURTH_PLACE(3, 5000),
    LOSER_PLACE(0, 0);

    companion object {
        fun of(matchCount: Int): Prize =
            values().find { it.matchCount == matchCount } ?: LOSER_PLACE
    }
}
