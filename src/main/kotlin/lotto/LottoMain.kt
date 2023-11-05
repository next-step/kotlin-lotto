package lotto

import lotto.domain.Lotto
import lotto.domain.LottoCalculator
import lotto.domain.LottoMachine
import lotto.domain.LottoRank
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val inputView: InputView = InputView()
    val buyingPrice: Int = inputView.readLineNumber("구입금액을 입력해 주세요.")

    val lottoMachine: LottoMachine = LottoMachine()
    val lottoList: List<Lotto> = lottoMachine.buyLottoList(buyingPrice)

    lottoList.forEach { println(it.getLottoNumberList()) }

    println()
    val winningLottoNumberList: List<Int> = inputView.readLineNumberList("지난 주 당첨 번호를 입력해 주세요.")
    val winningLotto: Lotto = Lotto(*winningLottoNumberList.toIntArray())

    val lottoRankList: List<LottoRank> = lottoList.map { lottoMachine.getLottoRank(it, winningLotto) }

    val lottoCalculator: LottoCalculator = LottoCalculator()
    val outputView: OutputView = OutputView()

    outputView.printResult(lottoRankList, lottoCalculator.calculateReturnOnInvestment(lottoRankList, buyingPrice.toDouble()))
}
