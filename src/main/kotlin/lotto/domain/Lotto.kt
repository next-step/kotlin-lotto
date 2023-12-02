package lotto.domain

class Lotto(
    val numbers: LottoNumbers,
) {
    fun match(winningLotto: WinningLotto): MatchedLotto {
        val correctCount = winningLotto.lotto.numbers.containsCount(numbers)
        val matchBonus = numbers.contains(winningLotto.bonusNumber)

        return MatchedLotto(this, LottoWinning.of(correctCount, matchBonus))
    }

    companion object {
        const val NUMBERS_COUNT = 6

        fun of(numbers: List<Int>): Lotto {
            val lottoNumbers = LottoNumbers(numbers.map { LottoNumber(it) })

            return Lotto(lottoNumbers)
        }
    }
}
