package lotto.model

/**
 * 로또 등수와 상금 정리한 클래스
 * */
enum class LottoRank(val countOfMatch: Int, val winningMoney: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    companion object {
        fun findMatchRank(number: Int): LottoRank {
            return values().find { it.countOfMatch == number } ?: MISS
        }
    }
}
