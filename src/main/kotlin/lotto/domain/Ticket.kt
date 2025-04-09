package lotto.domain

class Ticket(val lottoNumber: Set<LottoNumber>) {
    constructor() : this(generateLottoNumber())

    constructor(input: List<Int>) : this(input.map { LottoNumber(it) }.toSet())

    fun contains(bonusNumber: LottoNumber): Boolean {
        return lottoNumber.contains(bonusNumber)
    }

    companion object {
        private const val AMOUNT_OF_NUMBER_FOR_TICKET = 6

        private fun generateLottoNumber(): Set<LottoNumber> {
            val numbers = mutableSetOf<LottoNumber>()
            while (numbers.size < AMOUNT_OF_NUMBER_FOR_TICKET) {
                numbers.add(LottoNumber())
            }
            return numbers
        }
    }
}
