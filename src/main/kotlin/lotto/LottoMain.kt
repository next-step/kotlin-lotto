package lotto

fun main() {
    val lottoInputView = LottoInputView()
    val lottoResultView = LottoResultView()
    val lottoStore = LottoStore()

    val purchaseAmount = lottoInputView.readInt(message = "구입금액을 입력해 주세요.")
    val lottoNumbers = lottoStore.purchase(purchaseAmount)
    lottoResultView.printPurchasedLottoNumbers(lottoNumbers)

    val lastWinLottoNumber = lottoInputView.readLottoNumber(message = "지난 주 당첨 번호를 입력해 주세요.")
    val bonusBallNumber = lottoInputView.readInt(message = "보너스 볼을 입력해 주세요.")
    val winningLottoNumber = WinningLottoNumber(winningNumber = lastWinLottoNumber, bonusBallNumber = bonusBallNumber)

    val rankingCountMap = winningLottoNumber.makeRankingCountMap(lottoNumbers)
    val totalRevenueRate = winningLottoNumber.getRevenueRate(lottoNumbers)
    lottoResultView.printLottoStatistics(rankingCountMap = rankingCountMap, totalRevenueRate = totalRevenueRate)
}
