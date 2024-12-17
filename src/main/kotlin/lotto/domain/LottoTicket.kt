package lotto.domain

import lotto.controller.GeneratorLottoNumbers
import lotto.controller.GeneratorRandomNumbers

data class LottoTicket(private val lottoNumbers: List<LottoNumber>) {
    init {
        require(lottoNumbers.size == 6) { "로또 티켓은 6개의 번호가 필요해요."}
    }

    fun correctNumberCount(ticket: LottoTicket): Int {
        return lottoNumbers.filter {
            ticket.lottoNumbers.contains(it)
        }.size
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
            return buildList {
                for (index in 1..count)
                    add(LottoTicket(numberGenerator.generateNumbers()))
            }
        }
    }
}
