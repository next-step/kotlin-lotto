package lotto.domain

import lotto.controller.WinningNumbers

class Ticket(val lottoNumber: Set<LottoNumber>) {
    constructor() : this(generateLottoNumber())

    init {
        require(lottoNumber.size == 6) {
            throw IllegalArgumentException("Please enter $AMOUNT_OF_NUMBER_FOR_TICKET numbers")
        }
    }

    constructor(input: List<Int>) : this(input.map { LottoNumber(it) }.toSet())

    fun checkMatches(winningNumbers: WinningNumbers): Int {
        return winningNumbers.numbers.intersect(lottoNumber).size
    }

    fun checkBonusMatches(winningNumbers: WinningNumbers): Boolean {
        return lottoNumber.contains(winningNumbers.bonusNumber)
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
