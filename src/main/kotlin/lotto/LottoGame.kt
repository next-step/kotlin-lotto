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
        val lottos = LottoShop().buyLotto(lottoMoney, manualLottos)
        println("수동으로 ${manualLottos.size}장, 자동으로 ${lottos.size}장을 구매했습니다.")
        lottos.forEach {
            println(it.numbers)
        }
        return lottos
    } catch (e: IllegalArgumentException) {
        println(e.message)
        buyLotto()
    }
    return listOf()
}

fun buyManualLottos(): List<String> {
    println("수동으로 구매할 로또 수를 입력해주세요.")
    val manualLottoCount = readln()

    println("수동으로 구매할 번호를 입력해 주세요.")
    return manualLottoCount.toInt().downTo(1).map { readln() }.toList()
}

fun showLottoResult(lottos: List<Lotto>) {
    println("지난 주 당첨 번호를 입력해 주세요.")
    val winLottoInput = readln()
    println("보너스 볼을 입력해 주세요.")
    val bonusBallInput = readln()
    try {
        val winLotto = WinLotto(winLottoInput, bonusBallInput)
        val lottoResult = LottoResult(winLotto, lottos)
        lottoResult.process()
        lottoResult.printResult()
    } catch (e: IllegalArgumentException) {
        println(e.message)
        showLottoResult(lottos)
    }
}
