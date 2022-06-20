package lotto

import kotlin.random.Random

class LottoTicket constructor() {
    var ticketList: List<LottoNumber>

    constructor(tickets: List<LottoNumber>) : this() {
        ticketList = tickets
    }

    init {
        ticketList = generateSequence { Random(Random.nextInt()).nextInt(LOTTO_NUMBER_RANGE.first, LOTTO_NUMBER_RANGE.last) }
            .distinct()
            .take(LOTTO_NUMBER_COUNT)
            .sorted()
            .toList()
            .map(::LottoNumber)
    }

    fun validate(winningNumbers: WinningLottoTicket) {
        require(winningNumbers.numbers.size == LOTTO_NUMBER_COUNT)
        require(LOTTO_NUMBER_RANGE.contains(winningNumbers.bonusNumber.number) && !winningNumbers.numbers.contains(winningNumbers.bonusNumber))
    }

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6
        private val LOTTO_NUMBER_RANGE = (1..45)
    }
}
