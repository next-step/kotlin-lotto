package lotto.domain

enum class PrizeGenerator(val matched: Int, val prize: Int) {

    THREE_MATCH(3, 5_000),
    FOUR_MATCH(4, 50_000),
    FIVE_MATCH(5, 1_500_000),
    BONUS_MATCH(5, 30_000_000),
    SIX_MATCH(6, 2_000_000_000);

    var count: Int = 0

    fun countRank() {
        this.count++
    }

    companion object {
        fun winningPrize() =
            (THREE_MATCH.count * THREE_MATCH.prize) + (FOUR_MATCH.count * FOUR_MATCH.prize) + (FIVE_MATCH.count * FIVE_MATCH.prize) + (SIX_MATCH.count * SIX_MATCH.prize)
    }
}
