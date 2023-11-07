package lotto_auto.lotto

data class WinningLotto(
    val winningNumbers: LottoNumbers,
    val bonusNumber: Int,
)

fun List<Int>.toWinningLotto(bonusNumber: Int) =
    WinningLotto(winningNumbers = this.toLottoNumbers(), bonusNumber = bonusNumber)
