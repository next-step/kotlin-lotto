package lotto.domain

object LottoPolicy {
    const val NUMBER_OF_LOTTO_NUMBER = 6
    const val MIN_LOTTO_NUMBER = 1
    const val MAX_LOTTO_NUMBER = 45
    val LOTTO_NUMBER_POOL = (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER).toList()
    const val PRICE = 1000
}
