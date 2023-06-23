package lotto.domain

class LottoShop(
    private val purchasePrice: Int,
    private val customNumbers: List<LottoNumbers>
) {
    fun sellLotto(): List<Lotto> {
        val lottoCount = getBuyLottoCount(purchasePrice, customNumbers.size)
        val autoLotto = autoLotto(lottoCount)
        val customLotto = customLotto(customNumbers)
        return autoLotto + customLotto
    }

    private fun autoLotto(lottoCount: Int): List<Lotto> {
        return buildList(lottoCount) {
            List(lottoCount) {
                val lottoNumbers = generateAutoNumber()
                add(Lotto(lottoNumbers))
            }
        }
    }

    private fun customLotto(customNumbers: List<LottoNumbers>): List<Lotto> {
        val lottoList: MutableList<Lotto> = mutableListOf()
        customNumbers.forEach {
            lottoList.add(Lotto(it))
        }
        return lottoList.toList()
    }

    private fun getBuyLottoCount(purchasePrice: Int): Int {
        return purchasePrice / LOTTO_PRICE
    }

    private fun getBuyLottoCount(purchasePrice: Int, customCount: Int): Int {
        return (purchasePrice - (customCount * LOTTO_PRICE)) / LOTTO_PRICE
    }

    fun generateAutoNumber(): LottoNumbers {
        val numbers = (START_LOTTO_NUMBER..LAST_LOTTO_NUMBER).shuffled()
            .subList(FROM_INDEX, TO_INDEX)
            .sorted()
        return LottoNumbers(numbers)
    }

    companion object {
        const val LOTTO_PRICE = 1_000
        const val START_LOTTO_NUMBER = 1
        const val LAST_LOTTO_NUMBER = 45
        const val FROM_INDEX = 0
        const val TO_INDEX = 6
    }
}
