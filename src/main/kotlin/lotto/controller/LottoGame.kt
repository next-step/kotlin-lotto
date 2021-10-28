package lotto.controller

import lotto.domain.Lotto
import lotto.domain.Lottos
import lotto.domain.Purchase
import lotto.dto.LottosDto
import lotto.infra.RandomNumberGenerator
import lotto.view.InputView
import lotto.view.OutputView

object LottoGame {
    fun run() {
        val lottos = Lottos(
            Purchase(InputView.askPurchase()).calculateQuantity(),
            RandomNumberGenerator()
        )
        OutputView.printLottos(LottosDto(lottos.exportLottos()))

        val winningLotto = Lotto.from(InputView.askWinningNumbers())
    }
}
