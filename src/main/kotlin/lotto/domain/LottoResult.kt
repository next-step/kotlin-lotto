package lotto.domain

enum class LottoResult(val winningAmount: Int, val matchCount: Int) {

    FIRST_PLACE(2000000000, 6),
    SECOND_PLACE(1500000, 5),
    THIRD_PLACE(50000, 4),
    FOURTH_PLACE(5000, 3),
    LOSE(0, 0);

    companion object {
        fun lottoResult(matchCount: Int): LottoResult {
            return values().find { it.matchCount == matchCount } ?: LOSE
        }
    }
}
