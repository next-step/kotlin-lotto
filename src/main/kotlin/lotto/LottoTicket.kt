package lotto

class LottoTicket private constructor(val numbers: List<LottoNumber>) {
    init {
        val lottoTicketSize = numbers.distinct().size
        require(lottoTicketSize == LOTTO_TICKET_SIZE) {
            "로또의 번호 개수는 ${LOTTO_TICKET_SIZE}개 입니다. (현재 : $lottoTicketSize)"
        }
    }

    fun matchCountWith(other: LottoTicket): Int {
        return numbers.intersect(other.numbers).size
    }

    fun hasNumber(number: LottoNumber): Boolean {
        return number in numbers
    }

    companion object {
        fun of(numbers: List<LottoNumber>): LottoTicket {
            return LottoTicket(numbers.sortedBy { it.number })
        }

        const val LOTTO_TICKET_SIZE = 6
    }
}
