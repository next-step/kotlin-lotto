package lotto.domain

data class LottoMatch(
    val matchNumber: Int,
    val reward: Long,
    var matchCount: Long = DEFAULT_MATCH_COUNT
) {
    companion object {
        const val DEFAULT_MATCH_COUNT = 0L
    }
}
