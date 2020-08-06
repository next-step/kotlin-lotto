package lotto.model

data class WinnerLotto(val lotto: Lotto, val bonusNumber: LottoNo) {
    init {
        require(!lotto.isIn(bonusNumber)) { "보너스 숫자는 로또의 숫자와 중복될 수 없습니다." }
    }

    fun contains(checkNumbers: List<LottoNo>): Int {
        return checkNumbers.filter { it in lotto.lottoNumbers }.map { it }.size
    }

    fun containsBonus(checkNumbers: List<LottoNo>): Boolean {
        return checkNumbers.filter { it == this.bonusNumber }.map { it }.isNotEmpty()
    }

    fun getPrize(number: Int, bonus: Boolean): Win {
        val win = Win.values().filter { it.matchNumber == number && it.matchBonus == bonus }

        if (win.isEmpty()) return Win.NONE

        return win[0]
    }
}
