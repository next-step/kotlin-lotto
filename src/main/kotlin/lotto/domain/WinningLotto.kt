package lotto.domain

private fun List<LottoNumber>.isValidNumberCount() = this.size == WinningLotto.COUNT_OF_NUMBER
private fun List<LottoNumber>.isNotDuplicatedWith(bonusNumber: LottoNumber): Boolean {
    val totalNumbers = this + bonusNumber
    return totalNumbers.size == totalNumbers.distinct().size
}

class WinningLotto(
    private val numbers: List<LottoNumber>,
    private val bonusNumber: LottoNumber
) {
    init {
        require(numbers.isValidNumberCount()) { "로또 숫자가 6개가 아닌 로또는 생성할 수 없습니다." }
        require(numbers.isNotDuplicatedWith(bonusNumber)) { "로또 숫자는 중복될 수 없습니다." }
    }

    fun calculateProfit(lottos: List<Lotto>): Pair<List<LottoRank>, Double> {
        val ranks = lottos.map {
            LottoRank.of(
                it.lottoNumbers.count { number -> numbers.contains(number) },
                it.lottoNumbers.contains(bonusNumber)
            )
        }
        val profit = calculateProfit(ranks)

        return Pair(ranks, profit)
    }

    private fun calculateProfit(ranks: List<LottoRank>): Double {
        require(ranks.isNotEmpty()) { "로또 계산은 1장 이상부터 가능합니다." }

        val totalPrize = ranks.fold(0.0) { total, it -> total + it.prize }

        return totalPrize / (ranks.size * Lotto.PRICE)
    }

    companion object {
        const val COUNT_OF_NUMBER = 6
    }
}
