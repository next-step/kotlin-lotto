package lotto.domain

enum class Winning(
    private val lottoMatch: LottoMatch,
    val money: Long
) {
    FIRST(LottoMatch.SIX, 20_000_000_000L),
    THIRD(LottoMatch.FIVE, 1_500_000L),
    FOURTH(LottoMatch.FOUR, 50_000L),
    FIFTH(LottoMatch.THREE, 5_000L),
    NONE(LottoMatch.NONE, 0L);

    companion object {
        fun of(lottoMatch: LottoMatch): Winning {
            return values().firstOrNull() { it.lottoMatch == lottoMatch } ?: NONE
        }
    }
}
