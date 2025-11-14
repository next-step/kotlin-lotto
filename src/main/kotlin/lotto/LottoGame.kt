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
    } catch (e: IllegalArgumentException) {
        println(e.message)
        showLottoResult(lottos)
    }
}

//    당첨 통계
//            ---------
//            3개 일치 (5000원)- 1개
//            4개 일치 (50000원)- 0개
//            5개 일치 (1500000원)- 0개
//            6개 일치 (2000000000원)- 0개
//            총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
