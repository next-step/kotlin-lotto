import lotto.controller.LottoGame
import lotto.domain.LottoPrice
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val buyingPrice = LottoPrice(InputView.enterLottoBuyingPrice())
    val manualLottoCount = InputView.enterManualLottoCount()
    val lottoTicket = LottoGame.start(buyingPrice, manualLottoCount)
    ResultView.printLottoTickets(lottoTicket)
    val result = LottoGame.doResult(lottoTicket, buyingPrice)
    ResultView.printResult(result)
}
