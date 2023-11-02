package lotto

import lotto.domain.Lotto
import lotto.domain.LottoStore
import lotto.domain.Lottos
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val inputPrice = InputView.inputPrice()
    val lottos = Lottos(LottoStore.buyLottos(inputPrice))
    OutputView.printLotto(lottos)

    val winningLotto = Lotto(InputView.inputWinningLotto())
}
