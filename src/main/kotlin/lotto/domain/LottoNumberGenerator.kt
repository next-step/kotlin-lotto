package lotto.domain

fun generateLottoNumbers(): LottoNumbers {
    val randomNumbers = (LottoNumber.LOTTO_NUMBER_MIN_VALUE..LottoNumber.LOTTO_NUMBER_MAX_VALUE)
        .shuffled().take(LottoNumbers.LOTTO_NUMBER_COUNT).sorted()
    return LottoNumbers(randomNumbers.map { LottoNumber.of(it) }.toSet())
}
