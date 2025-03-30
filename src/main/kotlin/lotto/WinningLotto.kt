package lotto

class WinningLotto(private val lotto: Lotto, private val bonusNumber: LottoNumber) {
    fun containBonusNumber(other: Lotto): Boolean {
        return other.contains(bonusNumber)
    }

    fun matchCount(other: Lotto): Int {
        return other.lottoNumbers.count { lotto.contains(it) }
    }
}
