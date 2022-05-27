package lotto

import lotto.domain.LottoProvider
import lotto.view.InputView
import lotto.view.OutputView

object LottoStore {
    fun open() {
        val provider = LottoProvider(InputView.readTotalPayment())

        OutputView.printNumberOfLottosBought(provider.numberOfLottos)
        OutputView.printLottoNumbers(provider.lottos)

        if (provider.numberOfLottos > 0) {
            val winningNumbers = InputView.readWinningNumbers()
        }
    }
}

fun main() {
    LottoStore.open()
}
