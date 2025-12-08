package lotto

fun main() {
    val lottoTicket = buyLotto()
    showLottoResult(lottoTicket)
}

fun buyLotto(): LottoTicket {
    println("구입금액을 입력해 주세요.")
    val moneyInput = readln()
    val money = Money(moneyInput)
    val lottoTicket = LottoShop.sellLotto(money)
    println("${lottoTicket.count()}개를 구매했습니다.")
    println(lottoTicket.lottos)
    return lottoTicket
}

fun showLottoResult(lottoTicket: LottoTicket) {
    println("지난 주 당첨 번호를 입력해 주세요.")
    val winLottoInput = readln()
    val winLotto = WinLotto(winLottoInput)

    println("보너스 볼을 입력해 주세요.")
    val bonusBallInput = readln()
    val bonusBallLotto = BonusBallLotto(winLotto, LottoNumber(bonusBallInput))
    val lottoResult = LottoResult(winLotto, bonusBallLotto, lottoTicket)
    lottoResult.process()
    lottoResult.printResult()
}
