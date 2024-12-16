package lotto.domain

import lotto.controller.GeneratorLottoNumbers
import lotto.controller.GeneratorRandomNumbers

data class LottoTicket(private val lottoNumbers: List<LottoNumber>) {
    init {
        require(lottoNumbers.size == 6)
    }

    fun correctNumberCount(ticket: LottoTicket): Int {
        var numberCount = 0
        lottoNumbers.forEach {
            if (ticket.lottoNumbers.contains(it)) {
                numberCount++
            }
        }
        return numberCount
    }

    override fun toString(): String {
        return lottoNumbers.joinToString(
            separator = ", ",
            prefix = "[",
            postfix = "]",
        )
    }

    companion object {
        fun generateLottoTickets(
            count: Int,
            numberGenerator: GeneratorLottoNumbers = GeneratorRandomNumbers,
        ): List<LottoTicket> {
            val tickets = mutableListOf<LottoTicket>()
            while (tickets.size < count) {
                tickets.add(LottoTicket(numberGenerator.generateNumbers()))
            }
            return tickets.toList()
        }
    }
}
