package lotto.vo

@JvmInline
value class LottoTicket(private val numbers: List<LottoNumber>) {
    init {
        require(numbers.size == LottoTicketSize) { "로또 번호는 6개여야 합니다." }
        require(numbers.distinct().size == 6) { "로또 번호는 중복될 수 없습니다." }
        require(numbers == numbers.sorted()) { "로또 번호는 오름차순으로 정렬되어야 합니다." }
    }

    fun countSameNumber(lottoTicket: LottoTicket): Int {
        return numbers.intersect(lottoTicket.numbers.toSet()).count()
    }

    companion object {
        const val LottoTicketSize = 6
    }
}
