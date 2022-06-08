package lotto

class LottoTicket private constructor(val numbers: Set<LottoNumber>) {
    init {
        val lottoTicketSize = numbers.size
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
        fun of(numbers: Set<LottoNumber>): LottoTicket {
            return LottoTicket(numbers.toSortedSet(compareBy { it.number }))
        }

        const val LOTTO_TICKET_SIZE = 6
    }
}
