package lotto.domain

import lotto.controller.GeneratorLottoNumbers
import lotto.controller.GeneratorRandomNumbers

class LottoTicket(elements: List<Int>) {
    private val lottoNumbers: List<LottoNumber> = elements.map { LottoNumber.from(it) }

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

    override fun equals(other: Any?): Boolean {
        return if (other is List<*>) {
            lottoNumbers == other
        } else {
            super.equals(other)
        }
    }

    override fun hashCode(): Int {
        return lottoNumbers.hashCode()
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
