package lotto

import lotto.domain.LottoProvider
import lotto.domain.WinningLotto
import lotto.domain.numbers.LottoNumbers
import lotto.domain.prize.LottoPrizeResult
import lotto.view.InputView
import lotto.view.OutputView

object LottoStore {
    fun open() {
        val payment = InputView.readTotalPayment()
        val numberOfCustomLotto = InputView.readNumberOfCustomLotto()

        if (!LottoProvider.isAffordable(payment, numberOfCustomLotto))
            throw IllegalArgumentException(LottoProvider.TOO_MANY_LOTTO_REQUESTED)

        val customLottos = InputView.readCustomLottoNumbers(numberOfCustomLotto)
            .map { LottoNumbers(it) }

        val provider = LottoProvider(payment, customLottos)
        OutputView.printLottoNumbers(provider.lottos)

        if (provider.numberOfLottos > 0) {
            val winningLotto = WinningLotto(InputView.readWinningNumbers(), InputView.readBonusBallNumber())

            val prizeResult = LottoPrizeResult(winningLotto, provider.lottos)

            OutputView.printLottoPrizeStatistics(payment, prizeResult)
        }
    }
}

fun main() {
    LottoStore.open()
}
