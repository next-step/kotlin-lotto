package lotto

fun main() {
    val insertAmount = View.insertAmount()
    val lottoStore = LottoStore(insertAmount)
    View.printAbleToPurchaseLottoCount(lottoStore)
    val purchasedLotto = lottoStore.purchase()
    View.printPurchasedLottoList(purchasedLotto)

    val lottoLuckyDraw = LottoLuckyDraw(View.getLuckyDrawNumber())
    lottoLuckyDraw.draw(purchasedLotto)

    val statistics = lottoLuckyDraw.statistics
    StatisticsView.getReport(statistics)
    StatisticsView.getResult(statistics, insertAmount)
}
