package lotto

import kotlin.random.Random

class LottoTicket constructor() {
    var ticket: List<Int>
    var count: Int = 0

    constructor(ticketList: List<Int>) : this() {
        ticket = ticketList
    }

    init {
        ticket = generateSequence { Random(Random.nextInt()).nextInt(LOTTO_NUMBER_RANGE.first, LOTTO_NUMBER_RANGE.last) }
            .distinct()
            .take(LOTTO_NUMBER_COUNT)
            .sorted()
            .toList()
    }

    fun validate(winningNumbers: List<Int>, bonusNumber: Int) {
        require(winningNumbers.size == LOTTO_NUMBER_COUNT)
        require(LOTTO_NUMBER_RANGE.contains(bonusNumber) && !winningNumbers.contains(bonusNumber))
    }

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6
        private val LOTTO_NUMBER_RANGE = (1..45)
    }
}
