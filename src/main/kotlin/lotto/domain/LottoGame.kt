package lotto.domain

class LottoGame(private val winning: WinningLotto) {

    fun match(lotto: Lotto) : LottoResult {
        return winning.match(lotto)
    }
}