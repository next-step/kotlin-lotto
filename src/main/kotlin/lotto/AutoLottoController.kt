package lotto

import lotto.domain.LottoGenerator
import lotto.dto.PurchaseAmount
import lotto.view.OutputView.writeSingleOutput
import lotto.vo.LottoNumber
import lotto.vo.LottoTicket

object AutoLottoController {
    private const val TicketPrice = 1000

    fun play(amount: PurchaseAmount): List<LottoTicket> {
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
