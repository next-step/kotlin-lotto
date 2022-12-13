package lotto.domain

class WinningNumber private constructor(winningLotto: Lotto, bonusNumber: LottoNumber) {
    val lotto = winningLotto.elements
    companion object {
        fun of(winningLotto: Lotto, bonusNumber: LottoNumber): WinningNumber = WinningNumber(winningLotto, bonusNumber)
    }
}
