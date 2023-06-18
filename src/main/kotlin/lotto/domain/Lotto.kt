package lotto.domain

class Lotto(
    val numbers: LottoNumbers = LottoNumbers.random(),
) {
    fun calculateResult(numbers: LottoNumbers): LottoRank? {
        return LottoRank.of(numbers.getIntersectCount(this.numbers))
    }

    companion object {
        const val PRICE = 1000
    }
}
