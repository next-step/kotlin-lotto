package lotto

fun main() {
    println("구입금액을 입력해 주세요.")
    val input = readln().toInt()
    val lottoStore = LottoStore(input)

    lottoStore.ableToPurchaseCount.also {
        println("${it}개를 구매했습니다.")
    }
    val purchasedLotto = lottoStore.purchase()
    purchasedLotto.forEach {
        println("[${it.numbers.joinToString()}]")
    }

    println("지난 주 당첨 번호를 입력해 주세요.")
    val drawNumber = readln()

    val lottoLuckyDraw = LottoLuckyDraw(drawNumber)
    lottoLuckyDraw.doLuckDraw(purchasedLotto)
    val statistics = lottoLuckyDraw.getStatistics

    statistics.getReport()
    statistics.getResult(input)
}
