import lotto.controller.LottoGame
import lotto.domain.LottoPrice
import lotto.domain.ManualNumbers
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val buyingPrice = LottoPrice(InputView.enterLottoBuyingPrice())
    val manualLottoCount = InputView.enterManualLottoCount()
    val lottoTicket = LottoGame.start(buyingPrice, askManualLotto(manualLottoCount))
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
