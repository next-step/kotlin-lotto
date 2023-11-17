package lotto

import lotto.domain.LottoGenerator
import lotto.dto.PurchaseAmountDto
import lotto.view.OutputView.writeSingleOutput
import lotto.domain.vo.LottoNumber
import lotto.domain.vo.LottoTicket

object AutoLottoController {
    private const val TicketPrice = 1000

    fun play(amount: PurchaseAmountDto): List<LottoTicket> {
        val chance = amount.amount / TicketPrice
        writeSingleOutput("$chance 개를 구매했습니다.")

        val lottoGenerator = LottoGenerator()
        repeat(chance) {
            lottoGenerator.generate()
        }

        return lottoGenerator.lottoTickets
    }

    fun getWinningTicket(input: String): LottoTicket {
        val numbers = input.replace("\\s".toRegex(), "")
            .split(",")
            .map { n -> n.toInt() }
            .map { n -> LottoNumber(n) }
        writeSingleOutput(numbers.toString())
        return LottoTicket(numbers)
    }
}
