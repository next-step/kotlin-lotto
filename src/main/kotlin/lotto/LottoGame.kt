package lotto

fun main() {
    val lottoTicket = buyLotto()
    showLottoResult(lottoTicket)
}

fun buyLotto(): LottoTicket {
    val money = MoneyInputView.process()
    val manualCount = ManualCount.read(money)
    val manualLottoOrder = ManualLottoOrder.create(manualCount)
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
