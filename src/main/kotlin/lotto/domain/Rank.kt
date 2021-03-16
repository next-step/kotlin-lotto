package lotto.domain

enum class Rank(val count: Int, val amount: Long, val matchCondition: String = "") {
    FAIL(0, 0),
    FIFTH(3, 5_000, "3개 일치"),
    FOURTH(4, 50_000, "4개 일치"),
    THIRD(5, 1_500_000, "5개 일치"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치"),
    FIRST(6, 2_000_000_000, "6개 일치");

    companion object {
        fun getRankByCount(count: Int, matchBonus: Boolean): Rank {
            val secondWonCondition = (count == SECOND.count && matchBonus)
            if (secondWonCondition) {
                return SECOND
            }

            return values().firstOrNull {
                it.count == count
            } ?: FAIL
        }

        fun getWonRank(): List<Rank> {
            return values().filter { it != FAIL }
        }

        fun getWonRank(): List<Rank> {
            return listOf(FORTH, THIRD, SECOND, FIRST)
        }
    }
}
