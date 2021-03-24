package lotto

import lotto.domain.Lotto
import lotto.domain.LottoMachine
import lotto.domain.LottoNumber
import lotto.domain.ManualLottoGenerator
import lotto.domain.Money
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
        val amount = userInterface.inputPurchaseAmount().let(::Money)
        val manualLottoCount = userInterface.inputManualLottoCount()
        val manualLottoNumbers =
            userInterface.inputManualLottoNumbers(count = manualLottoCount).map { it.map(::LottoNumber) }

        val lottos = lottoMachine.sellLottos(amount, manualLottoNumbers.map(::ManualLottoGenerator))
        userInterface.outputPurchasedMessage(
            lottos.toLottoNumbersDto(
                manualLottoCount = manualLottoCount,
                randomLottoCount = lottos.size - manualLottoCount
            )
        )

        val (winningLottoNumbers, winningLottoBonusNumber) = userInterface.inputLastWeekWinningLotto()

        val winningLotto = run {
            val lotto = Lotto(winningLottoNumbers.map { LottoNumber(it) })
            val bonusNumber = LottoNumber(winningLottoBonusNumber)
            WinningLotto(lotto = lotto, bonusNumber = bonusNumber)
        }

        val prizeRankCount = winningLotto.calculateLottoPrize(lottos)
        val profit = Profit(prizeRankCount, amount)

        userInterface.outputWinningStatistics(StatisticsDto.of(prizeRankCount, profit.rate()))
    }

    companion object {
        private val LOTTO_PRICE = Money(1000)
    }
}
