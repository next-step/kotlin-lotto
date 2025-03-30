package lotto

class WinningLotto(private val lotto: Lotto) {
    fun matchCount(other: Lotto): Int {
        return other.lottoNumbers.count { lotto.contains(it) }
    }
}
