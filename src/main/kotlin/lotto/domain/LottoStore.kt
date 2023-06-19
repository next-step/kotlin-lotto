package lotto.domain

class LottoStore(private val lottoPrice: Int = 1000) {
    private val lottoMinNumber: Int = 1
    private val lottoMaxNumber: Int = 45
    private val lottoCountOfNumbers: Int = 6
    private val lottoNumbers = (lottoMinNumber..lottoMaxNumber).toList()

    fun buyLottos(purchaseAmount: Int): List<Lotto> {
        val availableBuyCount = getAvailableBuyCount(purchaseAmount)
        if (availableBuyCount <= 0) {
            return emptyList()
        }
        return List(availableBuyCount) { _ -> Lotto(lottoNumbers.shuffled().subList(0, lottoCountOfNumbers)) }
    }

    private fun getAvailableBuyCount(purchaseAmount: Int): Int {
        return purchaseAmount / lottoPrice
    }
}
