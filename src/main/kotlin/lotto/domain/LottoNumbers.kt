package lotto.domain

object LottoNumbers {
    val LOTTO_NUMBERS = (LottoNumber.LOTTO_LOWER_BOUND..LottoNumber.LOTTO_UPPER_BOUND).map { LottoNumber(it) }
}
