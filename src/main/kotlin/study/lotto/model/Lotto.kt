package study.lotto.model

/**
 * @author 이상준
 */
data class Lotto(
    val lottoNumbers: Set<Int>,
) {
    fun matchLotto(winLotto: Lotto): Int {
        return winLotto.lottoNumbers.intersect(this.lottoNumbers).size
    }

    fun ishBonus(bonus: Int): Boolean {
        return this.lottoNumbers.contains(bonus)
    }
}
