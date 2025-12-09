package lotto

import lotto.domain.LottoResult
import lotto.domain.LottoShop
import lotto.domain.LottoTicket
import lotto.input.BonusBallInputView
import lotto.input.ManualCountInputView
import lotto.input.ManualLottoOrderInputView
import lotto.input.MoneyInputView
import lotto.input.WinLottoInputView
import lotto.output.LottoResultOutputView

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
    val winLotto = WinLottoInputView.process()
    val bonusBall = BonusBallInputView.process(winLotto)
    val lottoResult = LottoResult(winLotto, bonusBall, lottoTicket)
    LottoResultOutputView.print(lottoResult)
}
