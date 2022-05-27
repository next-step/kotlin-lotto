package lotto

import lotto.domain.LottoProvider
import lotto.view.InputView
import lotto.view.OutputView

object LottoStore {
    fun open() {
        val provider = LottoProvider(InputView.readTotalPayment())

        OutputView.printNumberOfLottosBought(provider.numberOfLottos)
        OutputView.printLottoNumbers(provider.lottos)
    }
}

fun main() {
    LottoStore.open()
}
