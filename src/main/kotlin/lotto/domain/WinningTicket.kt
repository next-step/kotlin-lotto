package lotto.domain

private const val BONUS_EXCEPTION = "보너스 볼은 로또번호와 달라야 합니다"

data class WinningTicket(val winningLotto: Lotto, val bonus: Int) {

    init {
        require(!winningLotto.contains(bonus)) { BONUS_EXCEPTION }
    }

    fun score(lotto: Lotto): Int {
        return this.winningLotto.getSameCount(lotto)
    }

    fun hasBonus(lotto: Lotto): Boolean {
        return lotto.contains(this.bonus)
    }
}
