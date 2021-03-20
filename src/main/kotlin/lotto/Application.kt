package lotto.view

import lotto.controller.LottoGame
import lotto.domain.BuyingLotto
import lotto.domain.LottoCount
import lotto.domain.LottoPrice
import lotto.domain.ManualLottoCount
import lotto.domain.ManualNumbers

fun main() {
    val buyingPrice = LottoPrice(InputView.enterLottoBuyingPrice())
    buyingPrice.getMaximumCount()
    val manualLottoCount = ManualLottoCount(buyingPrice, LottoCount.from(InputView.enterManualLottoCount()))
    val game = LottoGame(
        BuyingLotto(
            buyingPrice,
            askManualLotto(manualLottoCount)
        )
    )
    val lottoTicket = game.start()
    ResultView.printLottoTickets(lottoTicket)
    val result = game.doResult(lottoTicket)
    ResultView.printResult(result)
}

fun askManualLotto(manualLottoCount: ManualLottoCount): ManualNumbers? {
    if (manualLottoCount.count.isEmpty()) return null
    val manualNumbers = mutableListOf<String>()

    repeat(manualLottoCount.count.value) {
        manualNumbers.add(InputView.enterManualLottoNumbers(manualLottoCount.count))
    }

    return ManualNumbers(manualNumbers)
}
