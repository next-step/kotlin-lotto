package game.domain.result

private val MATCH_COUNT_RANGE = 0..6

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

data class LottoTicketMatchResult(private val matchCount: Int) {
    init {
        require(matchCount in MATCH_COUNT_RANGE) { "당첨 번호 개수는 6개를 초과할 수 없습니다." }
    }

    val rank = Rank.from(matchCount)
}

enum class Rank(val amount: Long, val matchCount: Int) {
    FIRST(2_000_000_000, 6),
    SECOND(1_500_000, 5),
    THIRD(50_000, 4),
    FOURTH(5_000, 3),
    NONE(0, 0),
    ;

    companion object {
        fun from(matchCount: Int): Rank {
            return Rank.values().find { it.matchCount == matchCount } ?: NONE
        }
    }
}
