package lotto

fun main() {
    val userAmount = InputView.readMessage("구입금액을 입력해 주세요.").toInt()
    val lottoMachine = LottoMachine()

    val user = User(Amount(userAmount))
    user.buyLotto(lottoMachine.autoGenerate)
    ResultView.print("${user.totalLottoSize}개를 구매했습니다.")
    ResultView.printBoughtLotto(user.totalLottos)

    val lastWeekNumbers = lottoMachine.createLotto(InputView.readCsvToInt("지난 주 당첨 번호를 입력해 주세요."))
    val bonusNumber: LottoNumber = lottoMachine.createLottoNumber(InputView.readMessage("보너스 볼을 입력해 주세요."))
    val lottoStatistics = user.statistics(lastWeekNumbers, bonusNumber)
    ResultView.printStatistics(lottoStatistics)
}
