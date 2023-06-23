package lotto.domain

class LottoShop(
    private val purchasePrice: Int
) {
    fun sellLotto(): List<Lotto> {
        val lottoCount = getBuyLottoCount(purchasePrice)
        return buildList(lottoCount) {
            List(lottoCount) { add(Lotto(generateAutoNumber())) }
        }
    }

    private fun getBuyLottoCount(purchasePrice: Int): Int {
        return purchasePrice / LOTTO_PRICE
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
