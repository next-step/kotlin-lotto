package lotto.view

import lotto.controller.LottoGame
import lotto.domain.BuyingLotto
import lotto.domain.LottoPrice
import lotto.domain.ManualNumbers

fun main() {
    val buyingPrice = LottoPrice(InputView.enterLottoBuyingPrice())
    val manualLottoCount = InputView.enterManualLottoCount(buyingPrice)
    val lottoTicket = LottoGame.start(BuyingLotto(buyingPrice, askManualLotto(manualLottoCount)))
    ResultView.printLottoTickets(lottoTicket)
    val result = LottoGame.doResult(lottoTicket, buyingPrice)
    ResultView.printResult(result)
}

fun askManualLotto(manualLottoCount: Int): ManualNumbers {
    val manualNumbers: MutableList<String> = mutableListOf()

    repeat(manualLottoCount) {
        manualNumbers.add(InputView.enterManualLottoNumbers())
    }

    return ManualNumbers(manualNumbers)
}
