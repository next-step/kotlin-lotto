package lotto.domain

class WinningLotto(
    val numbers: LottoNumbers = LottoNumbers.random(),
    val bonusNumber: LottoNumber = LottoNumber.random(),
)
