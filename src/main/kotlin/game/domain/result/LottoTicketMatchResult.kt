package game.domain.result

private val MATCH_COUNT_RANGE = 0..6

data class LottoTicketMatchResult(private val matchCount: Int) {
    init {
        require(matchCount in MATCH_COUNT_RANGE) { "당첨 번호 개수는 6개를 초과할 수 없습니다." }
    }

    val rank = Rank.from(matchCount)
}
