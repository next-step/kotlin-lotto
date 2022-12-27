package lotto.domain

data class WinningNumbers(
    val lottoNumbers: Set<LottoNumber>,
    val bonusBall: LottoNumber,
) : Set<LottoNumber> by lottoNumbers
