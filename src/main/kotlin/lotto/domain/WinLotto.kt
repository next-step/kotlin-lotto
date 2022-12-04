package lotto.domain

class WinLotto(private val _lotto: Lotto, private val _bonus: LottoNum) {

    val lotto: Lotto
        get() = this._lotto

    val bonus: LottoNum
        get() = this._bonus
}