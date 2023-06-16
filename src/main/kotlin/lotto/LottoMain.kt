package lotto

fun main() {
    val lottoInputView = LottoInputView()
    val lottoResultView = LottoResultView()
    val lottoStore = LottoStore()

    val purchaseAmount = lottoInputView.readPurchaseAmountFromConsole()
    val lottoNumbers = lottoStore.purchase(purchaseAmount)
    lottoResultView.printPurchasedLottoNumbers(lottoNumbers)

    val lastWinLottoNumber = lottoInputView.readLastWeekWinningLottoNumberFromConsole()

    val rankingCountMap = lastWinLottoNumber.makeRankingCountMap(lottoNumbers)
    val totalRevenueRate = lastWinLottoNumber.getRevenueRate(lottoNumbers)
    lottoResultView.printLottoStatistics(rankingCountMap = rankingCountMap, totalRevenueRate = totalRevenueRate)
}
