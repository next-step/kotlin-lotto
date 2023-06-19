package lotto

class LottoMaker(
    private val inputAmount: Int
) {

    fun createLottoNums(): List<Lotto> {
        val numOfLotto = getPurchasableNum()
        val result = mutableListOf<Lotto>()
        repeat(numOfLotto) {
            result += Lotto((LOWER_LIMIT..UPPER_LIMIT).toList().shuffled().take(COUNT_OF_LOTTO_NUM))
        }
        return result
    }

    fun getPurchasableNum(): Int {
        return inputAmount / PRICE
    }

    companion object {
        private const val PRICE = 1000
        private const val LOWER_LIMIT = 1
        private const val UPPER_LIMIT = 45
        private const val COUNT_OF_LOTTO_NUM = 6
    }
}