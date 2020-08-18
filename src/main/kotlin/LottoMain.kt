
import model.LottoNumber
import model.LottosGeneratorManual
import model.WinningLotto
import view.InputView
import view.ResultView

fun main() {
    var money = InputView.getMoney()
    val manual = InputView.getManualLottoCount()
    val manualLottoList = InputView.getManualLottoNumber(manual)
    val lottoGame = LottoGame()

    val lottoGeneratorManual = LottosGeneratorManual(manual, manualLottoList)
    val lottoList = lottoGame.buy(money, lottoGeneratorManual)

    ResultView.printLottoInfo(lottoGeneratorManual.lottoManualCount(), lottoGeneratorManual.lottoAutoCount(money))
    ResultView.printLottoList(lottoList)

    var prize = InputView.getPrizeLotto()

    val bonusBall = InputView.getBonusBall()
    val winningLotto = WinningLotto(prize, LottoNumber.from(bonusBall))

    val winningResult = lottoGame.match(lottoList, winningLotto, money)

    ResultView.printLottoStat(winningResult.stat())
    ResultView.printEarningRate(winningResult.earningRate())
}
