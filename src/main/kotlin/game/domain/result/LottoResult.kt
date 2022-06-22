package game.domain.result

private val MATCH_COUNT_RANGE = 0..6
private val NO_NEED_TO_CHECK: Boolean? = null

class LottoResult(_values: List<LottoTicketMatchResult>) {
    init {
        require(_values.isNotEmpty()) { "로또 결과는 빈 값일 수 없습니다." }
    }

    val value = _values.groupingBy { it.rank }.eachCount()

    fun profit(): Double {
        return sumOfAmount() / (value.values.sum() * 1000)
    }

    private fun sumOfAmount(): Double {
        return value.map { it.key.amount * it.value }.sumOf { it.toDouble() }
    }
}

data class LottoTicketMatchResult(private val matchCount: Int, private val matchBonus: Boolean) {
    init {
        require(matchCount in MATCH_COUNT_RANGE) { "당첨 번호 개수는 ${MATCH_COUNT_RANGE.maxOf { it }}개를 초과할 수 없습니다." }
    }

    val rank = Rank.from(matchCount, matchBonus)
}


enum class Rank(
    val amount: Long,
    val requiredMatchCount: Int,
    val requiredMatchBonus: Boolean?
) {
    FIRST(2_000_000_000, 6, false),
    SECOND(30_000_000, 5, true),
    THIRD(1_500_000, 5, false),
    FOURTH(50_000, 4, NO_NEED_TO_CHECK),
    FIFTH(5_000, 3, NO_NEED_TO_CHECK),
    NONE(0, 0, NO_NEED_TO_CHECK),
    ;

    val matcher = { matchCount: Int, matchBonus: Boolean ->
        requiredMatchCount == matchCount && (requiredMatchBonus == NO_NEED_TO_CHECK || requiredMatchBonus == matchBonus)
    }

    companion object {
        fun from(matchCount: Int, matchBonus: Boolean): Rank {
            return Rank.values().find { it.matcher(matchCount, matchBonus) } ?: NONE
        }
    }
}
