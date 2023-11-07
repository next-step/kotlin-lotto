package lotto.domain

enum class Jackpot(matchCount: Int, price: Int) {
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    SIX_MATCH(6, 2000000000)
}
