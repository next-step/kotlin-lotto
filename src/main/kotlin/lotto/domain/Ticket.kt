package lotto.domain

const val AMOUNT_OF_NUMBER_FOR_TICKET = 6

class Ticket(val lottoNumber: Set<LottoNumber>) {
    constructor() : this(generateLottoNumber())
    constructor(input: List<Int>) : this(input.map { LottoNumber(it) }.toSet())

    companion object {
        private fun generateLottoNumber(): Set<LottoNumber> {
            return List(AMOUNT_OF_NUMBER_FOR_TICKET) { LottoNumber() }.toSet()
        }
    }
}
