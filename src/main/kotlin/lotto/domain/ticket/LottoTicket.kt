package lotto.domain.ticket

import lotto.domain.LottoNumber

sealed class LottoTicket(
    val numbers: Set<LottoNumber>
) {
    init {
        require(numbers.size == TICKET_SIZE) {
            "로또 티켓은 중복되지 않은 ${TICKET_SIZE}개의 숫자로 이루어져야 합니다. LottoTicket: $numbers"
        }
    }

    fun hasNumber(lottoNumber: LottoNumber) = numbers.contains(lottoNumber)

    fun findMatchNumber(numbers: List<LottoNumber>): List<LottoNumber> {
        return numbers.filter { this.numbers.contains(it) }
    }

    class AutomaticLottoTicket(numbers: Set<LottoNumber>) : LottoTicket(numbers)

    class ManualLottoTicket(numbers: List<String>) : LottoTicket(numbers.toLottoNumbers())

    companion object {
        const val TICKET_SIZE = 6

        fun create() = LottoNumber.getLottoNumbers()
            .shuffled()
            .take(TICKET_SIZE)
            .toRandomTicket()

        private fun Iterable<LottoNumber>.toRandomTicket() = AutomaticLottoTicket(this.toSet())
    }
}

private fun Iterable<String>.toLottoNumbers(): Set<LottoNumber> {
    return this.map { LottoNumber.of(it) }
        .toSet()
}
