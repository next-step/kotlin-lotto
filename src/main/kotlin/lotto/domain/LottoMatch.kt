package lotto.domain

enum class LottoMatch(val matchCount: Int) {
    NONE(0),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6);

    companion object {
        fun of(matchCount: Int): LottoMatch {
            return values().firstOrNull() { it.matchCount == matchCount } ?: NONE
        }
    }
}
