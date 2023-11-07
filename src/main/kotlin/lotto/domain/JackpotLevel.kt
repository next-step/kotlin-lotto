package lotto.domain

enum class JackpotLevel(val matchCount: Int, val price: Int) {
    NO_MATCH(0, 0),
    ONE_MATCH(1, 0),
    TWO_MATCH(2, 0),
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    SIX_MATCH(6, 2000000000);

    companion object {
        fun getJackpotLevel(matchNumberCount: Int): JackpotLevel {
            return values().firstOrNull { it.matchCount == matchNumberCount } ?: NO_MATCH
        }
    }
}
