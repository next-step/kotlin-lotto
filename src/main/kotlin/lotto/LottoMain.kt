package lotto

import lotto.domain.Lotto
import lotto.domain.LottoCalculator
import lotto.domain.LottoMachine
import lotto.domain.LottoRank
import lotto.domain.LottoRank.Companion.getLottoRank
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val inputView: InputView = InputView()
    val outputView: OutputView = OutputView()
    val lottoMachine: LottoMachine = LottoMachine()
    val lottoCalculator: LottoCalculator = LottoCalculator()

    val buyingPrice: Int = inputView.readLineNumber("구입금액을 입력해 주세요.")

    val lottoList: List<Lotto> = lottoMachine.buyLottoList(buyingPrice)
    outputView.printLottoNumberList(lottoList)

    val winningLottoNumberList: List<Int> = inputView.readLineNumberList("지난 주 당첨 번호를 입력해 주세요.")
    val bonusNumber: Int = inputView.readLineNumber("보너스 볼을 입력해 주세요.")
    val winningLotto: Lotto = Lotto(winningLottoNumberList)

    val lottoRankList: List<LottoRank> = lottoList.map { it.getLottoRank(winningLotto, bonusNumber) }
    outputView.printResult(
        lottoRankList,
        lottoCalculator.calculateReturnOnInvestment(lottoRankList, buyingPrice.toDouble())
    )
}
