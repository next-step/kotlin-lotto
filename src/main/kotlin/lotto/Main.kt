package lotto

import lotto.domain.AutoLottoNumbersGenerateStrategy
import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoStore
import lotto.domain.Lottos
import lotto.domain.ManualLottoNumbersGenerateStrategy
import lotto.domain.WinningLotto
import lotto.ui.InputView
import lotto.ui.ResultView

fun main() {
    val store = LottoStore()

    val money = InputView.inputMoney()
    val boughtManualLottoCounts = InputView.inputManualLottoCount()

    val manualLottosPrice = boughtManualLottoCounts * LottoStore.LOTTO_PRICE

    require(money >= manualLottosPrice) {
        "로또를 구매할 돈이 부족합니다."
    }

    val manualLottos = List(boughtManualLottoCounts) {
        val lottoNumbers = InputView.inputManualLottoNumber()

        store.buyLotto(ManualLottoNumbersGenerateStrategy(lottoNumbers))
    }.let { Lottos(it) }

    val autoLottos = store.buyLottos(money - manualLottosPrice, AutoLottoNumbersGenerateStrategy())

    val boughtLottos = manualLottos + autoLottos

    ResultView.showBoughtLottos(boughtLottos, boughtManualLottoCounts)

    val winningLotto = WinningLotto(Lotto.of(InputView.inputWinningNumbers()), LottoNumber(InputView.inputBonusNumber()))
    val matchedLotto = boughtLottos.matchAll(winningLotto)

    val returnRate = matchedLotto.totalReward() / money.toDouble()

    ResultView.showResult(matchedLotto, returnRate)
}
