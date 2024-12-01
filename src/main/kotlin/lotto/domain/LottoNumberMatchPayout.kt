package lotto.domain

enum class LottoNumberMatchPayout(val matchCount: Int, val matchCountPayout: Int) {
    NO_NUMBER_MATCH(matchCount = 0, matchCountPayout = 0),
    ONE_NUMBER_MATCH(matchCount = 1, matchCountPayout = 0),
    TWO_NUMBER_MATCH(matchCount = 2, matchCountPayout = 0),
    THREE_NUMBER_MATCH(matchCount = 3, matchCountPayout = 5000),
    FOUR_NUMBER_MATCH(matchCount = 4, matchCountPayout = 50000),
    FIVE_NUMBER_MATCH(matchCount = 5, matchCountPayout = 1500000),
    SIX_NUMBER_MATCH(matchCount = 6, matchCountPayout = 2000000000),
    ;

    companion object {
        fun byMatchCount(matchCount: Int): LottoNumberMatchPayout {
            val findLottoMatchCountPayout = entries.find { it.matchCount == matchCount }
            requireNotNull(findLottoMatchCountPayout) { INVALID_MATCH_COUNT_MESSAGE }
            return findLottoMatchCountPayout
        }

        const val INVALID_MATCH_COUNT_MESSAGE: String = "로또 번호 매칭 카운트는 0부터 6까지만 존재할 수 있습니다"
    }
}
