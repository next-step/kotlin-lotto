package lotto.domain

enum class Grade(val matchCount: Int, val reward: Int) {
    First(6, 2000000000),
    Second(5, 1500000),
    Third(4, 50000),
    Fourth(3, 5000),
    None(0, 0);

    companion object {
        fun valueOf(matchCount: Int): Grade {
            return Grade.values().find { it.matchCount == matchCount } ?: None
        }
    }
}
