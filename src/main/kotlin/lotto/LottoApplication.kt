package lotto

import lotto.domain.LottoMachine
import lotto.domain.LottoNumber
import lotto.domain.RandomLottoGenerator
import lotto.domain.WinningLotto
import lotto.dto.toLottoNumbersDto
import lotto.userInterface.Console

fun main() {
    val console = Console()
    val app = LottoApplication(console)
    app.run()
}

class LottoApplication(private val userInterface: Console) {

    private val lottoMachine = LottoMachine(LOTTO_PRICE, RandomLottoGenerator())

    fun run() {
        val amount = userInterface.inputPurchaseAmount()
        val lottos = lottoMachine.sellLottos(amount)
        userInterface.outputPurchasedMessage(lottos.toLottoNumbersDto())

        val winningLottoNumbers = userInterface.inputLastWeekWinningLottoNumbers()
        WinningLotto(winningLottoNumbers.map { LottoNumber(it) })
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
