package lotto.domain

private fun List<LottoNumber>.isValidNumberCount() = this.size != WinningLotto.COUNT_OF_NUMBER

private fun List<LottoNumber>.isDuplicated() = this.size != this.distinct().size

class WinningLotto(
    private val numbers: List<LottoNumber>
) {
    init {
        if (numbers.isValidNumberCount()) {
            throw IllegalArgumentException("로또 숫자가 6개가 아닌 로또는 생성할 수 없습니다.")
        }

        if (numbers.isDuplicated()) {
            throw IllegalArgumentException("로또 숫자는 중복될 수 없습니다.")
        }
    }

    fun calculateProfit(lottos: List<Lotto>): Pair<List<LottoRank>, Double> {
        val ranks = lottos.map { it.lottoNumbers.count { number -> numbers.contains(number) } }.map { LottoRank.of(it) }
        val profit = calculateProfit(ranks)

        return Pair(ranks, profit)
    }

    private fun calculateProfit(ranks: List<LottoRank>): Double {
        if (ranks.isEmpty()) {
            throw IllegalArgumentException("로또 계산은 1장 이상부터 가능합니다.")
        }

        val totalPrize = ranks.fold(0.0) { total, it -> total + it.prize }

        return totalPrize / (ranks.size * Lotto.PRICE)
    }

    companion object {
        const val COUNT_OF_NUMBER = 6
    }
}
