package lotto

import lotto.domain.Lotto
import lotto.domain.LottoMachine
import lotto.domain.LottoNumber
import lotto.domain.LottoResult
import lotto.domain.RandomLottoGenerator
import lotto.domain.WinningLotto
import lotto.dto.StatisticsDto
import lotto.dto.toLottoNumbersDto
import lotto.userinterface.Console
import lotto.userinterface.UserInterface

fun main() {
    val console = Console()
    val app = LottoApplication(console)
    app.run()
}

class LottoApplication(private val userInterface: UserInterface) {

    private val lottoMachine = LottoMachine(LOTTO_PRICE, RandomLottoGenerator())

    fun run() {
        val amount = userInterface.inputPurchaseAmount()
        val lottos = lottoMachine.sellLottos(amount)
        userInterface.outputPurchasedMessage(lottos.toLottoNumbersDto())

        val winningLottoNumbers = userInterface.inputLastWeekWinningLottoNumbers()
        val winningLottoBonusNumber = userInterface.inputLastWeekWinningLottoBonusNumber()

        val winningLotto = run {
            val lotto = Lotto(winningLottoNumbers.map { LottoNumber(it) })
            val bonusNumber = LottoNumber(winningLottoBonusNumber)
            WinningLotto(lotto = lotto, bonusNumber = bonusNumber)
        }

        val result = LottoResult(winningLotto, lottos)
        userInterface.outputWinningStatistics(StatisticsDto.of(result.result(), amount))
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
