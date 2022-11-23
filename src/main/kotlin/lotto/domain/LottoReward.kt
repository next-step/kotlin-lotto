package lotto.domain

object LottoReward {

    fun reward(matchCount: Int): Int {
        check((0..6).contains(matchCount)) { "당첨 개수는 최대 6개 최소 0개 입니다" }
        return when (matchCount) {
            6 -> FIRST_WIN_PRICE
            5 -> SECOND_WIN_PRICE
            4 -> THIRD_WIN_PRICE
            3 -> FOURTH_WIN_PRICE
            else -> 0
        }
    }
}
