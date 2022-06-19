package game.domain.result

class LottoResult(_values: List<LottoTicketMatchResult>) {
    init {
        require(_values.isNotEmpty()) { "로또 결과는 빈 값일 수 없습니다." }
    }

    val value = _values.groupingBy { it.rank }.eachCount()

    fun profit(): Double {
        return sumOfAmount() / (value.size * 1000)
    }

    private fun sumOfAmount(): Double {
        return value.map { it.key.amount * it.value }.sumOf { it.toDouble() }
    }
}
