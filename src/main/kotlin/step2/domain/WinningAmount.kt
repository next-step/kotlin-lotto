package step2.domain

enum class WinningAmount(var label: String, var value: Int) {
    MATCH_THREE("3개 일치", 5000),
    MATCH_FOUR("4개 일치", 50000),
    MATCH_FIVE("5개 일치", 1500000),
    MATCH_SIX("6개 일치", 2000000000)
}
