package lotto.domain

data class WinningBalls(
    val lottoNumbers: Set<LottoNumber>,
    val bonusBall: LottoNumber,
) : Set<LottoNumber> by lottoNumbers
