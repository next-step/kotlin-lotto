package lotto.domain

enum class LottoMatch(val count: Int, val prize: Int, val hasBonusNumber: Boolean) {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    MISS(0, 0, false);

    companion object {
        fun findLottoMatch(count: Int, hasBonusNumber: Boolean): LottoMatch {
            return if (count != 5) {
                values().find { it.count == count } ?: MISS
            } else {
                values().find { it.count == count && it.hasBonusNumber == hasBonusNumber } ?: MISS
            }
        }
    }
}
