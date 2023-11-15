package lotto

import lotto.domain.Lotto
import lotto.domain.LottoCalculator
import lotto.domain.LottoMachine
import lotto.domain.LottoRank
import lotto.domain.LottoRank.Companion.getLottoRank
import lotto.view.InputView
import lotto.view.OutputView
import lotto.view.enum.Message

fun main() {
    val inputView: InputView = InputView()
    val outputView: OutputView = OutputView()
    val lottoCalculator: LottoCalculator = LottoCalculator()

    val buyingPrice: Int = inputView.readLineNumber(Message.QUESTION_MONEY)
    val lottoMachine: LottoMachine = LottoMachine(buyingPrice)

    val manualLottoCount: Int = inputView.readLineNumber(Message.QUESTION_MANUAL_COUNT)
    val remainingMoney: Int = buyingPrice - (manualLottoCount * 1000)
    require(remainingMoney >= 0) { "주어진 돈으로 살 수 없는 로또 개수입니다." }

    val manualLottoList: MutableList<Lotto> = mutableListOf()
    outputView.nextLinePrint(Message.QUESTION_MANUAL_LOTTO_NUMBER)
    repeat(manualLottoCount) {
        manualLottoList.add(Lotto(inputView.readLineNumberList()))
    }

    val lottoList: List<Lotto> = lottoMachine.buyLottoList()
    outputView.printBuySummary(manualLottoCount, lottoList.size)
    outputView.printLottoNumberList(lottoList)

    val resultLottoList: List<Lotto> = manualLottoList + lottoList

    val winningLottoNumberList: List<Int> = inputView.readLineNumberList(Message.QUESTION_WINNING_NUMBER)
    val bonusNumber: Int = inputView.readLineNumber(Message.QUESTION_BONUS_NUMBER)
    val winningLotto: Lotto = Lotto(winningLottoNumberList)

    val lottoRankList: List<LottoRank> = resultLottoList.map { it.getLottoRank(winningLotto, bonusNumber) }
    outputView.printResult(
        lottoRankList,
        lottoCalculator.calculateReturnOnInvestment(lottoRankList, buyingPrice.toDouble())
    )
}
