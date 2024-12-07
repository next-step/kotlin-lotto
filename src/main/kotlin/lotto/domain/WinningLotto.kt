package lotto.domain

class WinningLotto(private val lotto: Lotto, private val bonusNumber: LottoNumber) {
    init {
        if (containsBonusNumberIn(lotto)) {
            throw WinningLottoBonusNumberDuplicationException(lotto, bonusNumber)
        }
    }

    fun calculateMatchCount(userLotto: Lotto): Int {
        return lotto.calculateMatchCount(userLotto)
    }

    fun containsBonusNumberIn(lotto: Lotto): Boolean {
        return lotto.contains(bonusNumber)
    }
}
