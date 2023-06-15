package lotto

fun main() {
    val lottoInputView = LottoInputView()
    val lottoResultView = LottoResultView()
    val lottoStore = LottoStore()

    val purchaseAmount = lottoInputView.purchaseAmount
    val lottoNumbers = lottoStore.purchase(purchaseAmount)
    lottoResultView.printPurchasedLottoNumbers(lottoNumbers)

    val lastWinLottoNumber = lottoInputView.lastWeekWinLottoNumber

    lottoResultView.printLottoStatistics(lottoNumbers = lottoNumbers, winLottoNumber = lastWinLottoNumber)
}
