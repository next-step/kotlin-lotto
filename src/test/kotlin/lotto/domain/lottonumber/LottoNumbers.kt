package lotto.domain.lottonumber

fun lottoNumbers(vararg lottoNumbers: Int): LottoNumbers {
    return LottoNumbers(
        value = lottoNumbers.map { number ->
            LottoNumber(number)
        }
    )
}
