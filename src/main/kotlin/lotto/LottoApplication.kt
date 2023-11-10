package lotto

class LottoApplication(
    private val inputView: InputView,
    private val resultView: ResultView
) {

    fun run() {
        val money = inputView.inputMoney()
        val lottoMachine = LottoMachine(lottoGenerator(), money)
        resultView.printLottos(lottoMachine.issuedLottos)
        val winningLotto = inputView.inputWinningLotto()
        val statistics = lottoMachine.issueStatistics(Lotto(*winningLotto.toIntArray()))
        resultView.printStatistic(statistics)
    }

    private fun lottoGenerator(): LottoGenerator {
        return LottoGenerator { Lotto.random() }
    }
}
