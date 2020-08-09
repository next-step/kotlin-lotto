package lotto.domain

enum class Rank(val countOfMatch: Int, val winningMoney: Long, val matchBonus: Boolean = false) {
    FIRST(6, 2_000_000_000L),
    SECOND(5, 30_000_000L, true),
    THIRD(5, 1_500_000L),
    FOURTH(4, 50_000L),
    FIFTH(3, 5_000L),
    MISS(0, 0L);

    companion object {
        private const val INVALID_MESSAGE = "Rank를 찾을 수 없습니다."

        fun valueOf(countOfMatch: Int, matchBonus: Boolean = false): Rank {
            return values().find { it.countOfMatch == countOfMatch && it.matchBonus == matchBonus }
                ?: throw IllegalArgumentException(INVALID_MESSAGE)
        }
    }
}
