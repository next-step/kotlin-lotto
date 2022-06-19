package lotto.domain

private fun List<LottoNumber>.isValidNumberCount() = this.size != WinningLotto.COUNT_OF_NUMBER

private fun List<LottoNumber>.isDuplicated() = this.size != this.distinct().size

class WinningLotto private constructor(
    private val numbers: List<LottoNumber>
) {
    fun calculateProfit(lottos: List<Lotto>): Pair<List<Int>, Double> {
        val matchCounts = lottos.map { it.lottoNumbers.count { number -> numbers.contains(number) } }
        val profit = calculateProfit(matchCounts)

        return Pair(matchCounts, profit)
    }

    private fun calculateProfit(matchCounts: List<Int>): Double {
        if (matchCounts.isEmpty()) {
            throw IllegalArgumentException("로또 계산은 1장 이상부터 가능합니다.")
        }
        var prize = 0.0

        for (count in matchCounts) {
            prize += when (count) {
                FOURTH_MATCH_COUNT -> FOURTH_PRIZE
                THIRD_MATCH_COUNT -> THIRD_PRIZE
                SECOND_MATCH_COUNT -> SECOND_PRIZE
                FIRST_MATCH_COUNT -> FIRST_PRIZE
                else -> 0
            }
        }

        return prize / (matchCounts.size * Lotto.PRICE)
    }

    companion object {
        const val COUNT_OF_NUMBER = 6
        const val FOURTH_MATCH_COUNT = 3
        const val THIRD_MATCH_COUNT = 4
        const val SECOND_MATCH_COUNT = 5
        const val FIRST_MATCH_COUNT = 6
        const val FOURTH_PRIZE = 5000
        const val THIRD_PRIZE = 50000
        const val SECOND_PRIZE = 1500000
        const val FIRST_PRIZE = 2000000000

        fun create(lottoNumbers: List<LottoNumber>): WinningLotto {
            validateNumbers(lottoNumbers)

            return WinningLotto(lottoNumbers.sortedBy { it.number })
        }

        private fun validateNumbers(lottoNumbers: List<LottoNumber>) {
            if (lottoNumbers.isValidNumberCount()) {
                throw IllegalArgumentException("로또 숫자가 6개가 아닌 로또는 생성할 수 없습니다.")
            }

            if (lottoNumbers.isDuplicated()) {
                throw IllegalArgumentException("로또 숫자는 중복될 수 없습니다.")
            }
        }
    }
}
