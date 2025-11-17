package lotto

fun main() {
    val lottos = buyLotto()
    showLottoResult(lottos)
}

fun buyLotto(): List<Lotto> {
    println("구입금액을 입력해 주세요.")
    val moneyInput = readln()
    try {
        val money = Money(moneyInput)
        val buyLotto = LottoShop().buyLotto(money)
        println("${buyLotto.size}개를 구매했습니다.")
        buyLotto.forEach {
            println(it.numbers)
        }
        return buyLotto
    } catch (e: IllegalArgumentException) {
        println(e.message)
        buyLotto()
    }
    return listOf()
}

fun showLottoResult(lottos: List<Lotto>) {
    println("지난 주 당첨 번호를 입력해 주세요.")
    val winLottoInput = readln()
    try {
        val winLotto = WinLotto(winLottoInput)
        val lottoResult = LottoResult(winLotto, lottos)
        lottoResult.process()
        lottoResult.printResult()
    } catch (e: IllegalArgumentException) {
        println(e.message)
        showLottoResult(lottos)
    }
}
