package lotto.domain

enum class Grade(val matchCount: Int, val reward: Int) {
    First(6, 2_000_000_000),
    Second(5, 3_000_000),
    Third(5, 1_500_000),
    Fourth(4, 50_000),
    Five(3, 5_000),
    None(0, 0);

    companion object {
        fun find(matchCount: Int, matchBonus: Boolean): Grade {
            return when {
                matchCount == 5 -> if (matchBonus) Second else Third
                else -> Grade.values().find { it.matchCount == matchCount } ?: None
            }
        }
    }
}
