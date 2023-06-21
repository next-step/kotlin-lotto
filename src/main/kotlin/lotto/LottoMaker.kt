package lotto

import lotto.domain.Lotto
import lotto.domain.LottoNumber

class LottoMaker(
    private val inputAmount: Int
) {

    fun createLottoNums(): List<Lotto> {
        val numOfLotto = getPurchasableNum()
        val result = mutableListOf<Lotto>()
        repeat(numOfLotto) {
            val randomNumbers = (LOWER_LIMIT..UPPER_LIMIT).toList().shuffled().take(COUNT_OF_LOTTO_NUM)
            val lottoNumbers = randomNumbers.map { LottoNumber(it) }
            result += Lotto(lottoNumbers)
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