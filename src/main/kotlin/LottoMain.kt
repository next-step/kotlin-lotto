
import model.LottoNumber
import model.WinningLotto
import view.InputView
import view.ResultView

fun main() {
    var money = InputView.getMoney()
    val manual = InputView.getManualLottoCount()
    val manualLottoList = InputView.getManualLottoNumber(manual)
    val lottoGame = LottoGame()

    val lottoList = lottoGame.buy(money, manual, manualLottoList)

    ResultView.printLottoInfo(manual.value, lottoGame.autoMakeCount())
    ResultView.printLottoList(lottoList)

    var prize = InputView.getPrizeLotto()

    val bonusBall = InputView.getBonusBall()
    val winningLotto = WinningLotto(prize, LottoNumber.from(bonusBall))

    val winningResult = lottoGame.match(winningLotto)

    ResultView.printLottoStat(winningResult.stat())
    ResultView.printEarningRate(winningResult.earningRate())
}
