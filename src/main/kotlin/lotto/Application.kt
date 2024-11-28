package lotto

fun main() {
    val userAmount = InputView.getUserAmount()
    val lottoMachine = LottoMachine()

    val user = User(userAmount)
    val manualLottos: Lottos = InputView.getManualLotto(lottoMachine)

    user.buyManualLottos(manualLottos)
    user.buyAutoLotto(lottoMachine.autoGenerate)
    ResultView.printBoughtLotto(user)

    val lastWeekNumbers = InputView.getLastWeekNumbers(lottoMachine)
    val bonusNumber = InputView.getBonusNumber(lottoMachine)
    val lottoStatistics = LottoStatistics.from(user, lastWeekNumbers, bonusNumber)
    ResultView.printStatistics(lottoStatistics)
}
