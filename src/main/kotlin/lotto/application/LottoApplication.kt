package lotto.application

import lotto.view.LottoController

fun main() {
    LottoController.payoutResult(LottoController.lottoPurchased(), LottoController.lottoWinnerNumber())
}
