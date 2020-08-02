import manager.LottoManager
import view.InputView
import view.ResultView

fun main(args: Array<String>) {
    val inputView = InputView()
    val input = { readLine()!! }
    val money = inputView.inputMoneyForBuyLotto(input)
    val lottoManager = LottoManager()
    lottoManager.buy(money)
    inputView.showBuyLottoCount(lottoManager.lottoCount)

    val resultView = ResultView()
    resultView.showLottoList(lottoManager.lottoList)

    val prize = inputView.inputLastWeekPrize(input)
    lottoManager.prize = prize.map { it.toInt() }

    resultView.showPrizeList(lottoManager.prizeList)
}
