package lotto.domain

class LottoSeller {

    private val lottoMachine = LottoMachine()

    fun purchase(inputPrice: Long, inputManualLottoNumbers: List<LottoNumbers>): List<Lotto> {
        val numberOfPurchases = numberOfPurchases(inputPrice)
        if (numberOfPurchases == 0) return emptyList()
        val autoLottoCount = numberOfPurchases - inputManualLottoNumbers.size
        return purchaseManually(inputManualLottoNumbers) + purchaseAuto(autoLottoCount)
    }

    private fun purchaseManually(inputManualLottoNumbers: List<LottoNumbers>): List<Lotto> {
        return inputManualLottoNumbers
            .map { lottoMachine.generate(it) }
    }

    private fun purchaseAuto(autoLottoCount: Int): List<Lotto> {
        return List(autoLottoCount) {
            lottoMachine.generate()
        }
    }

    private fun numberOfPurchases(inputPrice: Long): Int {
        return (inputPrice / LOTTO_PRICE).toInt()
    }

    companion object {
        const val LOTTO_PRICE: Long = 1_000
    }
}
