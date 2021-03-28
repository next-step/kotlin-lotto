package lotto

import lotto.domain.LottoMachine
import lotto.domain.LottoNumber
import lotto.domain.ManualLottoGenerator
import lotto.domain.Money
import lotto.domain.Profit
import lotto.domain.RandomLottoGenerator
import lotto.domain.WinningLotto
import lotto.dto.LottoNumbersDto
import lotto.dto.StatisticsDto
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
        val amount = userInterface.inputPurchaseAmount(LOTTO_PRICE.value.toInt()).let(::Money)
        val manualLottoNumbers = userInterface.inputManualLottoNumbers().map { it.map(::LottoNumber) }

        val lottos = lottoMachine.sellLottos(amount, manualLottoNumbers.map(::ManualLottoGenerator))
        val manualLottoCount = manualLottoNumbers.count()
        val randomLottoCount = lottos.count() - manualLottoCount

        userInterface.outputPurchasedMessage(LottoNumbersDto(manualLottoCount, randomLottoCount, lottos))

        val (winningLottoNumbers, winningLottoBonusNumber) = userInterface.inputLastWeekWinningLotto()
        val winningLotto = WinningLotto(lottoNumbers = winningLottoNumbers, bonusNumber = winningLottoBonusNumber)

        val prizeRankCount = winningLotto.calculateLottoPrize(lottos)
        val profit = Profit(prizeRankCount, amount)

        userInterface.outputWinningStatistics(StatisticsDto(prizeRankCount, profit.rate()))
    }

    companion object {
        private val LOTTO_PRICE = Money(1000)
    }
}
