package lotto.domain

class LottoStore(val lottoPrice: Int = 1000) {

    fun buyLottos(purchaseAmount: Int, manualNumbers: List<List<Int>> = emptyList()): List<Lotto> {

        val manualLottos = createLottosManually(purchaseAmount, manualNumbers)

        val remains = purchaseAmount - lottoPrice * manualLottos.size

        val automaticLottos = createLottosAutomatic(remains)

        return manualLottos + automaticLottos
    }

    private fun createLottosManually(purchaseAmount: Int, rawNumberslist: List<List<Int>>): List<Lotto> {
        val availableCountOfPurchase = getAvailableCountOfPurchase(purchaseAmount)
        require(availableCountOfPurchase >= rawNumberslist.size) { " 수동으로 구입할 금액이 부족합니다 " }

        return rawNumberslist.map { rawNumbers -> Lotto(rawNumbers) }.toList()
    }

    private fun createLottosAutomatic(purchaseAmount: Int): List<Lotto> {
        val availableCountOfPurchase = getAvailableCountOfPurchase(purchaseAmount)
        if (availableCountOfPurchase <= 0) {
            return emptyList()
        }
        return List(availableCountOfPurchase) { Lotto(LottoNumber.RANGE.shuffled().subList(0, Lotto.NUMBER_COUNT)) }
    }

    private fun getAvailableCountOfPurchase(purchaseAmount: Int): Int {
        return purchaseAmount / lottoPrice
    }
}
