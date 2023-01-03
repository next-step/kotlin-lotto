package lotto.domain

class LottoMachine(val price: Int, private val manualLottoInfo: ManualLottoInfo) {

    val purchaseCount: Int
    private val autoCount: Int

    init {
        require(price % LOTTO_BASE_PRICE == 0) { "input incorrectly price" }
        purchaseCount = price / LOTTO_BASE_PRICE
        autoCount = purchaseCount - manualLottoInfo.manualCount
    }

    fun publishLotto(): PublishLotto {
        return PublishLotto(publishManualLottoList(), publishAutoLottoList())
    }

    private fun publishAutoLottoList(): List<Lotto> {
        return (0 until autoCount).map { Lotto(createNumbers()) }
    }

    private fun publishManualLottoList(): List<Lotto> {
        return manualLottoInfo.lottoStrings.map { manualLottoString ->
            val stringNumbers = StringNumbers(manualLottoString)
            val lottoNumbers = stringNumbers.numbers.map { numberStr ->
                LottoNumber(numberStr.trim().toInt())
            }
            Lotto(lottoNumbers.toSet())
        }
    }

    private fun createNumbers(): Set<LottoNumber> {
        val shuffledNumbers = LottoNumber.RANGE.shuffled().take(6).sorted()
        return shuffledNumbers.map { LottoNumber(it) }.toSet()
    }

    companion object {
        private const val LOTTO_BASE_PRICE = 1000
    }
}
