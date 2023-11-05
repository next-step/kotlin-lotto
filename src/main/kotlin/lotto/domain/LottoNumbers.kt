package lotto.domain

data class LottoNumbers(
    val numbers: List<LottoNumber> = (LottoNumber.MIN_LOTTO_NUMBER..LottoNumber.MAX_LOTTO_NUMBER).map { LottoNumber(it) }
) {
    fun generate(): Lotto {
        val lottoNumbers = numbers.shuffled()
            .take(Lotto.LOTTO_COUNT)
            .sortedBy { it.value }
        return Lotto(lottoNumbers)
    }
}
