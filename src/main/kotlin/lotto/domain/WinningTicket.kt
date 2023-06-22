package lotto.domain

data class WinningTicket(val winningLotto: Lotto, val bonus: Int) {
    fun score(lotto: Lotto): Int {
        return this.winningLotto.getSameCount(lotto)
    }

    fun hasBonus(lotto: Lotto): Boolean {
        return lotto.contains(this.bonus)
    }
}
