package lotto.domain

enum class LottoMatch(val count: Int, val prize: Int) {
    NONE(0, 0),
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

    companion object {
        fun findLottoMatch(count: Int): LottoMatch {
            return values().find { it.count == count } ?: NONE
        }
    }
}
