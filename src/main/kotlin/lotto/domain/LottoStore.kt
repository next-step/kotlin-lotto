package lotto.domain

class LottoStore(val lottoPrice: Int = 1000) {

    fun buyLottos(purchaseAmount: Int): List<Lotto> {
        val availableBuyCount = getAvailableBuyCount(purchaseAmount)
        if (availableBuyCount <= 0) {
            return emptyList()
        }

        return List(availableBuyCount) { createLottoAutomatic() }
    }

    private fun createLottoAutomatic(): Lotto {
        val pickedNumbers = LottoNumber.RANGE.shuffled().subList(0, Lotto.NUMBER_COUNT)
        return Lotto(pickedNumbers.map { LottoNumber(it) }.toHashSet())
    }

    private fun getAvailableBuyCount(purchaseAmount: Int): Int {
        return purchaseAmount / lottoPrice
    }
}
