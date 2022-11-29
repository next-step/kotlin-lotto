package lotto

enum class LottoMatch(val matchCount: Int) {
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6);

    companion object {
        fun of(matchCount: Int): LottoMatch {
            return values().first { it.matchCount == matchCount }
        }
    }
}
