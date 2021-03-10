package lotto.domain

data class WinningLotto(
    val winningNumbers: List<LottoNumber>,
    val bonusNumber: LottoNumber
)
