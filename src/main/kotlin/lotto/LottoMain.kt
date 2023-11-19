package lotto

import lotto.domain.Lotto
import lotto.domain.LottoAmount
import lotto.domain.LottoCalculator
import lotto.domain.LottoMachine
import lotto.domain.LottoNumber
import lotto.domain.LottoRank
import lotto.view.InputView
import lotto.view.OutputView
import lotto.view.enum.Message

fun main() {
    val inputView: InputView = InputView()
    val outputView: OutputView = OutputView()
    val lottoCalculator: LottoCalculator = LottoCalculator()

    val buyingPrice: Int = inputView.readLineNumber(Message.QUESTION_MONEY)
    val lottoMachine: LottoMachine = LottoMachine(LottoAmount(buyingPrice))

    val manualLottoCount: Int = inputView.readLineNumber(Message.QUESTION_MANUAL_COUNT)
    val manualLottoList: MutableList<Lotto> = mutableListOf()
    repeat(manualLottoCount) {
        val lottoNumberList: List<Int> = inputView.readLineNumberList(Message.QUESTION_MANUAL_LOTTO_NUMBER)

        manualLottoList.add(lottoMachine.buyLotto(lottoNumberList))
    }

    val lottoList: List<Lotto> = lottoMachine.buyLottoList()
    outputView.printBuySummary(manualLottoCount, lottoList.size)
    outputView.printLottoNumberList(lottoList)

    val winningLottoNumberList: List<Int> = inputView.readLineNumberList(Message.QUESTION_WINNING_NUMBER)
    val winningLotto: Lotto = Lotto(winningLottoNumberList)
    val bonusNumber: LottoNumber = LottoNumber(inputView.readLineNumber(Message.QUESTION_BONUS_NUMBER))

    val resultLottoList: List<Lotto> = manualLottoList + lottoList
    val lottoRankList: List<LottoRank> = resultLottoList.map { it.getLottoRank(winningLotto, bonusNumber) }
    outputView.printResult(
        lottoRankList,
        lottoCalculator.calculateReturnOnInvestment(lottoRankList, buyingPrice.toDouble())
    )
}
