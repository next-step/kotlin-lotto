package lotto

class LottoRule(val correctNumber: List<Int>) {
    fun calculatePrize(lotto: Lotto): Prize {
        val sameCount = correctNumber.count { lotto.contains(it) }
        return Prize.fromSameCount(sameCount)
    }
}
