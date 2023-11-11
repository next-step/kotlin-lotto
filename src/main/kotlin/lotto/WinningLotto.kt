package lotto

class WinningLotto(val lotto: Lotto, bonusNumber: Int) {

    fun judge(lotto: Lotto): Prize {
        return lotto.judge(this)
    }
}
