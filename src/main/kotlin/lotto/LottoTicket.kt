package lotto

class LottoTicket(numbers: List<Int>) {
    private val _lottoNumbers: Set<Int>
    val lottoNumbers: Set<Int>
        get() = _lottoNumbers.toSet()

    init {
        require(numbers.size == 6 && numbers.toSet().size == 6) { "로또 티켓 번호가 잘못 입력되었습니다" }
        _lottoNumbers = numbers.toSortedSet()
    }

    companion object {
        fun generateLottoNumber(): LottoTicket {
            val lottoNumbers =
                (1..45) // .map { LottoNumber(it.first) }
                    .shuffled()
                    .take(6)
            return LottoTicket(lottoNumbers)
        }
    }
}