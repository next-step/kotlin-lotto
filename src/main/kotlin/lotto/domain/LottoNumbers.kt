package lotto.domain

object LottoNumbers {
    private const val LOTTO_LOWER_BOUND = 1
    private const val LOTTO_UPPER_BOUND = 45

    val LOTTO_NUMBERS = (LOTTO_LOWER_BOUND..LOTTO_UPPER_BOUND).map { LottoNumber(it) }
}
