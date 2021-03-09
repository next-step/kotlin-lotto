package lotto.domain.ticket

import lotto.domain.LottoNumber

class LottoTicket(
    val numbers: Set<LottoNumber>
) {

    init {
        if (numbers.size != TICKET_SIZE) {
            throw IllegalArgumentException("로또 티켓은 중복되지 않은 6개의 숫자로 이루어져야 합니다. LottoTicket: $numbers")
        }
    }

    fun fillMatchNumber(matchNumbers: MutableList<LottoNumber>, number: LottoNumber) {
        if (numbers.contains(number)) {
            matchNumbers.add(number)
        }
    }

    companion object {
        const val TICKET_SIZE = 6

        fun create() = LottoNumber.getLottoNumbers()
            .shuffled()
            .take(TICKET_SIZE)
            .toTicket()


        private fun Iterable<LottoNumber>.toTicket() = LottoTicket(this.toSet())
    }
}
