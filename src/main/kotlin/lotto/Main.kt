package lotto

import lotto.domain.IssuedLottoMatchResult
import lotto.domain.IssuedLottos
import lotto.domain.LottoNumber
import lotto.domain.LottoSeller
import lotto.domain.WinningLotto
import lotto.domain.toLottoNumberSet
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()
    val lottoSeller = LottoSeller()

    val seedMoney: Int = inputView.inputSeedMoney()
    val issuedLottos: IssuedLottos = lottoSeller.sell(seedMoney)
    resultView.outputIssuedLottos(issuedLottos)

    val winningNumbers: Set<LottoNumber> = inputView.inputWinningNumbers().toLottoNumberSet()
    val bonusNumber: LottoNumber = LottoNumber.from(inputView.inputBonusNumber())
    val issuedLottoMatchResult: IssuedLottoMatchResult = issuedLottos.check(WinningLotto(winningNumbers, bonusNumber))
    resultView.outputLottoMatchStat(issuedLottoMatchResult.matchStat)

    val earningsRate: Double = issuedLottoMatchResult.calculateEarningsRate(seedMoney)
    resultView.outputEarningsRate(earningsRate)
}
