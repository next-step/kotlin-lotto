package lotto.domain

enum class Grade(val matchCount: Int, val reward: Int) {
    First(6, 2_000_000_000),
    Second(5, 1_500_000),
    Third(4, 50_000),
    Fourth(3, 5_000),
    None(0, 0);

    companion object {
        fun find(matchCount: Int): Grade {
            return Grade.values().find { it.matchCount == matchCount } ?: None
        }
    }
}
