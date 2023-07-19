package lottogame.domain

import lottogame.domain.lotto.LottoMachine
import lottogame.ui.LottoGameInput
import lottogame.ui.LottoGameOutput

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
