package lotto.domain

object LottoRewardCalculator {

    fun calculate(matchingCount: Int): Int {
        check((Lotto.START_LOTTO_INDEX..Lotto.LAST_LOTTO_INDEX).contains(matchingCount)) { "당첨 개수는 최대 6개 최소 0개 입니다" }
        val winner: Winner = Winner.safeValueOf(matchingCount)
        return winner.prize
    }
}
