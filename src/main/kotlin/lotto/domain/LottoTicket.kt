package lotto.domain

import lotto.controller.GeneratorRandomNumbers

class LottoTicket {
    private val lottoNumbers = mutableListOf<LottoNumber>()

    // 중복된 번호를 입력 할 수 없다
    constructor(vararg elements: LottoNumber) {
        lottoNumbers.addAll(elements)
    }
    constructor(vararg elements: Int) {
        elements.mapTo(
            lottoNumbers,
        ) { number ->
            LottoNumber(number)
        }
    }

    constructor(elements: List<Int>) {
        elements.mapTo(
            lottoNumbers,
        ) { number ->
            LottoNumber(number)
        }
    }

    fun correctNumberCount(ticket: LottoTicket): Int {
        var numberCount = 0
        lottoNumbers.forEach {
            if (ticket.lottoNumbers.contains(it)) {
                numberCount++
            }
        }
        println("$ticket equal number count $numberCount")
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
        // 숫자 리스트를 통해 로또 티켓 생성
        fun generateTickets(arrayTicketNumbers: List<List<Int>>): List<LottoTicket> {
            val tickets = mutableListOf<LottoTicket>()

            arrayTicketNumbers.forEach {
                tickets.add(LottoTicket(it))
            }

            return tickets.toList()
        }

        fun generateLottoTickets(count: Int): List<LottoTicket> {
            val tickets = mutableListOf<LottoTicket>()
            while (tickets.size < count) {
                tickets.add(LottoTicket(GeneratorRandomNumbers.generateNumbers(6)))
            }
            return tickets.toList()
        }
    }
}
