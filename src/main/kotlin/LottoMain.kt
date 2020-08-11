
import model.WinningLotto
import view.InputView
import view.ResultView

fun main() {
    var money = InputView.getMoney()
    val lottoGame = LottoGame()

    val lottoList = lottoGame.buy(money)

    ResultView.printLottoList(lottoList)

    var prize = InputView.getPrizeLotto()

    val bonusBall = InputView.getBonusBall()
    val winningLotto = WinningLotto(prize, bonusBall)

    val winningResult = lottoGame.match(winningLotto)

    ResultView.printLottoStat(winningResult.stat())
    ResultView.printEarningRate(winningResult.earningRate())
}
