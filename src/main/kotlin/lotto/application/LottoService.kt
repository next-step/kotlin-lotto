package lotto.application

import lotto.domain.*
import lotto.domain.Lotto
import lotto.domain.LottoMachine
import lotto.domain.WinningMachine
import lotto.domain.generator.RandomGenerator
import lotto.view.InputView
import lotto.view.ResultView

fun main(args: Array<String>) {
    val amount = InputView.requireAmountOfPurchaseLotto()
    val lottoIssueResult = purchaseLottos(amount)
    ResultView.printPurchaseLotto(lottoIssueResult)
    val statistics = winningStatistic(lottoIssueResult)
    ResultView.printStatistics(statistics, amount)
}

private fun purchaseLottos(amount: Amount): LottoIssueResult {
    val lottoMachine = LottoMachine(RandomGenerator())
    val manualCount = InputView.requireCountOfPurchaseManualLotto()
    val manualLottos = InputView.requirePurchaseManualLottoNum(manualCount)
    return lottoMachine.issue(amount, manualLottos)
}

private fun winningStatistic(lottoIssueResult: LottoIssueResult): Statistics {
    val winLottoNum = Lotto(InputView.requireWinLottoNum())
    val bonusNum = LottoNum.of(InputView.requireWinBonusNum())
    val winningMachine = WinningMachine(WinLotto(winLottoNum, bonusNum))
    return winningMachine.match(lottoIssueResult)
}