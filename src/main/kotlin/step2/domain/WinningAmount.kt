package step2.domain

enum class WinningAmount(val label: String, val count: Int, val reward: Int) {
    MATCH_THREE("3개 일치", 3, 5000),
    MATCH_FOUR("4개 일치", 4, 50000),
    MATCH_FIVE("5개 일치", 5, 1500000),
    MATCH_SIX("6개 일치", 6, 2000000000)
}
