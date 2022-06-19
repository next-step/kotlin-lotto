package game.domain.result

class LottoResult(val results: List<LottoTicketMatchResult>) {
    init {
        require(results.isNotEmpty()) { "로또 결과는 빈 값일 수 없습니다." }
    }

    fun profit(): Double {
        return results.sumOf { it.rank.amount }.toDouble() / (results.size * 1000)
    }
}
