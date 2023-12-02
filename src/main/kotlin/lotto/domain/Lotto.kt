package lotto.domain

class Lotto(
    val numbers: LottoNumbers,
) {
    init {
        require(numbers.size == NUMBERS_COUNT) {
            "로또 번호는 항상 ${NUMBERS_COUNT}개 여야 합니다."
        }
        require(!numbers.hasDuplicate()) {
            "로또 번호는 중복이 없어야 합니다."
        }
        require(numbers.isSorted()) {
            "로또 번호는 항상 정렬되어야 합니다."
        }
    }

    fun match(winningLotto: WinningLotto): MatchedLotto {
        val correctCount = winningLotto.lotto.numbers.containsCount(numbers)
        val matchBonus = numbers.contains(winningLotto.bonusNumber)

        return MatchedLotto(this, LottoWinning.of(correctCount, matchBonus))
    }

    companion object {
        const val NUMBERS_COUNT = 6
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45

        fun of(numbers: List<Int>): Lotto {
            val lottoNumbers = LottoNumbers(numbers.map { LottoNumber(it) })

            return Lotto(lottoNumbers)
        }
    }
}
