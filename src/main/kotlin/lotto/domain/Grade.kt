package lotto.domain

enum class Grade(val matchCount: Int, val matchBonus: Boolean, val reward: Int) {
    First(6, false, 2_000_000_000),
    Second(5, true, 3_000_000),
    Third(5, false, 1_500_000),
    Fourth(4, false, 50_000),
    Five(3, false, 5_000),
    None(0, false, 0);

    companion object {
        fun find(matchCount: Int, matchBonus: Boolean): Grade {
            return when {
                matchCount == Second.matchCount -> if (matchBonus) Second else Third
                else -> Grade.values().find { it.matchCount == matchCount } ?: None
            }
        }
    }
}
