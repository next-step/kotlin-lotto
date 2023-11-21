package lotto.model

data class LottoInput(
    val lottoNumbers: List<LottoNumbers>,
    val winningNumbers: WinningNumbers,
    val bonusNumber: LottoNumber
)
