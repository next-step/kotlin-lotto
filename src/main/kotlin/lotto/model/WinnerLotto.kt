package lotto.model

data class WinnerLotto(val lotto: Lotto, val bonusNumber: LottoNo) {
    init {
        require(!bonusNumber.isIn(lotto.lottoNumbers)) { "보너스 숫자는 로또의 숫자와 중복될 수 없습니다." }
    }

    fun contains(checkNumbers: List<LottoNo>): Int {
        return checkNumbers.filter { it in lotto.lottoNumbers }.map { it }.size
    }

    fun containsBonus(checkNumbers: List<LottoNo>): Boolean {
        return checkNumbers.filter { it.number == this.bonusNumber.number }.map { it }.isNotEmpty()
    }
}
