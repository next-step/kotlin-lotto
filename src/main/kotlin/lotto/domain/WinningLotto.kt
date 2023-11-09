package lotto.domain

data class WinningLotto(val lotto: Lotto, val bonusNumber: LottoNumber) {

    fun matchCount(other: Lotto): Int {
        val otherNumbers = other.numbers
        return lotto.numbers.intersect(otherNumbers).count()
    }
}
