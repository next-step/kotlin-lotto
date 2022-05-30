package lotto

import lotto.domain.LottoProvider
import lotto.domain.WinningLotto
import lotto.domain.prize.LottoPrizeResult
import lotto.view.InputView
import lotto.view.OutputView

object LottoStore {
    fun open() {
        val payment = InputView.readTotalPayment()
        val provider = LottoProvider(payment)

        OutputView.printNumberOfLottosBought(provider.numberOfLottos)
        OutputView.printLottoNumbers(provider.lottos)

        if (provider.numberOfLottos > 0) {
            val winningLotto = WinningLotto(InputView.readWinningNumbers())

            val prizeResult = LottoPrizeResult(winningLotto, provider.lottos)

            OutputView.printLottoPrizeStatistics(payment, prizeResult)
        }
    }
}

fun main() {
    LottoStore.open()
}
