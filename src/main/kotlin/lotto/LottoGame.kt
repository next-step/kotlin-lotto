package lotto

fun main() {
    val lottoTicket = buyLotto()
    showLottoResult(lottoTicket)
}

fun buyLotto(): LottoTicket {
    val money = Money.read()
    val manualCount = ManualCount.read(money)
    val manualLottoOrder = ManualLottoOrder.create(manualCount)
    val lottoTicket = LottoShop.sellLotto(money, manualLottoOrder)
    lottoTicket.print()
    return lottoTicket
}

fun showLottoResult(lottoTicket: LottoTicket) {
    println("지난 주 당첨 번호를 입력해 주세요.")
    val winLotto = WinLotto(readln())

    println("보너스 볼을 입력해 주세요.")
    val bonusBallLotto = BonusBallLotto(winLotto, LottoNumber(readln()))
    val lottoResult = LottoResult(winLotto, bonusBallLotto, lottoTicket)
    lottoResult.process()
    lottoResult.printResult()
}
