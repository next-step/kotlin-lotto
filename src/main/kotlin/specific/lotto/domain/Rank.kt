package specific.lotto.domain

enum class Rank(val prize: Long, val condition: String) {
    FIRST(2000000000L, "6개 일치"),
    SECOND(30000000L, "5개 일치, 보너스 볼 일치"),
    THIRD(1500000L, "5개 일치"),
    FOURTH(50000L, "4개 일치"),
    FIFTH(5000L, "3개 일치"),
    NO_WIN(0L, "2개 이하 일치");

    companion object {
        fun decideRank(countOfSameNumber: Int, hasBonusNumber: Boolean): Rank {
            return when(countOfSameNumber) {
                6 -> FIRST
                5 -> when(hasBonusNumber) {
                    true -> SECOND
                    false -> THIRD
                }
                4 -> FOURTH
                3 -> FIFTH
                else -> NO_WIN
            }
        }
    }
}
