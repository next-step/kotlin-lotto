package lotto.domain

import lotto.view.OutputView
import lotto.domain.vo.LottoNumber
import lotto.domain.vo.LottoTicket

class LottoGenerator {
    var lottoTickets: ArrayList<LottoTicket> = arrayListOf()

    fun generate() {
        val numbers = (LottoNumber.LottoLowerBound..LottoNumber.LottoUpperBound)
            .shuffled()
            .take(LottoTicket.LottoTicketSize)
            .map { n -> LottoNumber(n) }
            .sorted()

        val lottoTicket = LottoTicket(numbers)
        OutputView.writeSingleOutput(numbers.toString())

        lottoTickets.add(lottoTicket)
    }
}
