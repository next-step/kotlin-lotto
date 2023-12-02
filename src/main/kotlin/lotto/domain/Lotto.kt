package lotto.domain

class Lotto(
    val numbers: List<LottoNumber>,
) {
    init {
        require(numbers.size == NUMBERS_COUNT) {
            "로또 번호는 항상 ${NUMBERS_COUNT}개 여야 합니다."
        }
        require(numbers.distinct().size == NUMBERS_COUNT) {
            "로또 번호는 중복이 없어야 합니다."
        }
        require(numbers.isSortedNumber()) {
            "로또 번호는 항상 정렬되어야 합니다."
        }
    }

    fun match(winningLotto: WinningLotto): MatchedLotto {
        val correctCount = winningLotto.lotto.numbers.count { numbers.contains(it) }
        val matchBonus = numbers.contains(winningLotto.bonusNumber)

        return MatchedLotto(this, LottoWinning.of(correctCount, matchBonus))
    }

    private fun List<LottoNumber>.isSortedNumber(): Boolean {
        return map { it.value }
            .zipWithNext { a, b -> a <= b }
            .all { it }
    }

    companion object {
        const val NUMBERS_COUNT = 6
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45

        fun of(numbers: List<Int>): Lotto {
            return Lotto(numbers.map { LottoNumber(it) })
        }
    }
}
