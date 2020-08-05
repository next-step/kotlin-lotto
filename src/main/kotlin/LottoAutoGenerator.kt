import manager.LottoManager
import view.InputView
import view.ResultView

fun main(args: Array<String>) {
    val inputView = InputView()
    val inputMoeny = { readLine()!! }
    inputView.inputMoneyForBuyLotto(inputMoeny)
    val money = inputView.money
    val lottoManager = LottoManager()
    lottoManager.buy(money)
    inputView.showBuyLottoCount(lottoManager.lottoCount)

    ResultView.showLottoList(lottoManager.lottoList)
    val inputPrize = { readLine()!! }
    inputView.inputLastWeekPrize(inputPrize)
    val prize = inputView.prize
    lottoManager.setPrize(prize.map { it.toInt() })

    ResultView.showPrizeList(lottoManager.prizeStatList)
    ResultView.showEarningRate(lottoManager.earningRate)
}
