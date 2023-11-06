package lotto.service

import lotto.domain.Lotto
import lotto.domain.LottoNumber

object LottoCounter {
    private const val LOTTO_PRICE = 1000
    private const val RANDOM_LOWER_BOUND = 1
    private const val RANDOM_UPPER_BOUND = 45
    private const val LOTTO_NUMBER_COUNT = 6

    fun getLottoCount(money: Int): Int = money / LOTTO_PRICE

    fun purchase(money: Int): List<Lotto> {
        val count = money / LOTTO_PRICE
        return List(count) { Lotto(generate()) }
    }

    private fun generate(): List<LottoNumber> =
        List(LOTTO_NUMBER_COUNT) { LottoNumber((RANDOM_LOWER_BOUND..RANDOM_UPPER_BOUND).random()) }
}
