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

    val manualLottoCount: Int = inputView.readLineNumber("수동으로 구매할 로또 수를 입력해 주세요.")
    val remainingMoney: Int = buyingPrice - (manualLottoCount * 1000)
    require(remainingMoney >= 0) { "주어진 돈으로 살 수 없는 로또 개수입니다." }

    val manualLottoList: MutableList<Lotto> = mutableListOf()
    outputView.nextLinePrint("수동으로 구매할 번호를 입력해 주세요.")
    repeat(manualLottoCount) {
        val manualLottoNumberList: List<Int> = inputView.readLineNumberList()

        manualLottoList.add(Lotto(manualLottoNumberList))
    }

    val lottoList: List<Lotto> = lottoMachine.buyLottoList(remainingMoney)
    outputView.printBuySummary(manualLottoCount, lottoList.size)
    outputView.printLottoNumberList(lottoList)

    val resultLottoList: List<Lotto> = manualLottoList + lottoList

    val winningLottoNumberList: List<Int> = inputView.readLineNumberList("지난 주 당첨 번호를 입력해 주세요.")
    val bonusNumber: Int = inputView.readLineNumber("보너스 볼을 입력해 주세요.")
    val winningLotto: Lotto = Lotto(winningLottoNumberList)

    val lottoRankList: List<LottoRank> = resultLottoList.map { it.getLottoRank(winningLotto, bonusNumber) }
    outputView.printResult(
        lottoRankList,
        lottoCalculator.calculateReturnOnInvestment(lottoRankList, buyingPrice.toDouble())
    )
}
