package lotto.domain

import lotto.domain.GameMoney
import lotto.domain.LottoMachine
import lotto.ui.LottoGameInput
import lotto.ui.LottoGameOutput

class LottoGame(
    private val input: LottoGameInput,
    private val output: LottoGameOutput
) {
    fun run() {
        val lottoMachine = LottoMachine()
        val gameMoney = GameMoney.from(input.money())
        val lottoTicket = lottoMachine.generateTicket(gameMoney, input.manualLottos())
        output.printPurchasedTicket(lottoTicket)

        val winningLotto = lottoMachine.toWinningLotto(input.numbers(), input.bonusNumber())
        val matches = lottoTicket.match(winningLotto)
        output.printStatistics(matches, gameMoney)
    }
}
