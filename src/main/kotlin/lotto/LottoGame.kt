package lotto

import lotto.domain.BonusBallLotto
import lotto.domain.LottoResult
import lotto.domain.LottoShop
import lotto.domain.LottoTicket
import lotto.domain.WinLotto
import lotto.input.ManualCountInputView
import lotto.input.ManualLottoOrderInputView
import lotto.input.MoneyInputView

fun main() {
    val lottoTicket = buyLotto()
    showLottoResult(lottoTicket)
}

fun buyLotto(): LottoTicket {
    val money = MoneyInputView.process()
    val manualCount = ManualCountInputView.process(money)
    val manualLottoOrder = ManualLottoOrderInputView.process(manualCount)
    val lottoTicket = LottoShop.sellLotto(money, manualLottoOrder)
    lottoTicket.print()
    return lottoTicket
}

fun showLottoResult(lottoTicket: LottoTicket) {
    val winLotto = WinLotto.read()
    val bonusBallLotto = BonusBallLotto.read(winLotto)
    val lottoResult = LottoResult(winLotto, bonusBallLotto, lottoTicket)
    lottoResult.process()
    lottoResult.printResult()
}
