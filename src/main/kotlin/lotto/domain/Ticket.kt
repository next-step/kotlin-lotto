package lotto.domain

const val AMOUNT_OF_NUMBER_FOR_TICKET = 6

class Ticket(val lottoNumber: Set<LottoNumber>) {
    constructor() : this(generateLottoNumber())

    companion object {
        private fun generateLottoNumber(): Set<LottoNumber> {
            return List(AMOUNT_OF_NUMBER_FOR_TICKET) { LottoNumber() }.toSet()
        }
    }
}
