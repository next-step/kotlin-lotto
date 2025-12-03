package lotto

fun main() {
    val lottos = buyLotto()
    showLottoResult(lottos)
}

fun buyLotto(): List<Lotto> {
    println("구입금액을 입력해 주세요.")
    val moneyInput = readln()
    try {
        val lottoMoney = LottoMoney(moneyInput)
        val manualLottos = buyManualLottos()
        val autoLottos = LottoShop().buyLotto(lottoMoney, manualLottos)
        println("${autoLottos.size}개를 구매했습니다.")
        autoLottos.forEach {
            println(it.numbers)
        }
        return autoLottos
    } catch (e: IllegalArgumentException) {
        println(e.message)
        buyLotto()
    }
    return listOf()
}

fun buyManualLottos(): List<String> {
    println("수동으로 구매할 로또 수를 입력해주세요.")
    return readln().toInt().downTo(1).map { readln() }.toList()
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
