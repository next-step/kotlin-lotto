package model

class WinningLotto(override val lotto: List<LottoNumber>, private val bonusNumber: Int = 1) : BasicLotto
