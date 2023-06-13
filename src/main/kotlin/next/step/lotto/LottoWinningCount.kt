package next.step.lotto

enum class LottoWinningCount(val matchCount: Int, val winnings: Int) {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000),
    NONE(0, 0);
    
    companion object {
        fun from(matchCount: Int): LottoWinningCount = values().find { it.matchCount == matchCount } ?: NONE
    }

}