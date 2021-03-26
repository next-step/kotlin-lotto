import lotto.controller.LottoGame
import lotto.view.ResultView

fun main() {
    val lottoTicket = LottoGame.start()
    ResultView.printLottoTickets(lottoTicket)
    val result = LottoGame.doResult(lottoTicket)
    ResultView.printResult(result)
}
