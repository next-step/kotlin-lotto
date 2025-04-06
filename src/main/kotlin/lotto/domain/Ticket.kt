package lotto.domain

private const val AMOUNT_OF_NUMBER_FOR_TICKET = 6

class Ticket(val lottoNumber: List<LottoNumber>) {
    constructor() : this(generateLottoNumber())

    companion object {
        private fun generateLottoNumber(): List<LottoNumber> {
            return List(AMOUNT_OF_NUMBER_FOR_TICKET) { LottoNumber() }
        }
    }
}
