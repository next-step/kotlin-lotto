import manager.LottoManager
import view.InputView
import view.ResultView

fun main(args: Array<String>) {
    val inputView = InputView()
    val inputMoeny = { readLine()!! }
    val money = inputView.inputMoneyForBuyLotto(inputMoeny)
    val lottoManager = LottoManager()
    lottoManager.buy(money)
    inputView.showBuyLottoCount(lottoManager.lottoCount)

    val resultView = ResultView()
    resultView.showLottoList(lottoManager.lottoList)
    val inputPrize = { readLine()!! }
    val prize = inputView.inputLastWeekPrize(inputPrize)
    lottoManager.prize = prize.map { it.toInt() }

    resultView.showPrizeList(lottoManager.prizeStatList)
    resultView.showEarningRate(lottoManager.earningRate)
}
