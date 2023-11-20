package lotto.domain

class Lotto(
    val numbers: List<Int>,
    val winning: LottoWinning = LottoWinning.Miss,
) {
    init {
        require(numbers.size == NUMBERS_COUNT) {
            "로또 번호는 항상 ${NUMBERS_COUNT}개 여야 합니다."
        }
        require(numbers.distinct().size == NUMBERS_COUNT) {
            "로또 번호는 중복이 없어야 합니다."
        }
        require(numbers.all { it in MIN_NUMBER..MAX_NUMBER }) {
            "로또 번호는 항상 ${MIN_NUMBER}에서 ${MAX_NUMBER}사이 값이어야 합니다."
        }
        require(numbers.isSortedNumber()) {
            "로또 번호는 항상 정렬되어야 합니다."
        }
    }

    fun match(winningLotto: WinningLotto): Lotto {
        val correctCount = winningLotto.lotto.numbers.count { numbers.contains(it) }
        val matchBonus = numbers.contains(winningLotto.bonusNumber)

        return Lotto(
            numbers = numbers,
            winning = LottoWinning.of(correctCount, matchBonus)
        )
    }

    private fun List<Int>.isSortedNumber(): Boolean {
        return zipWithNext { a, b -> a <= b }.all { it }
    }

    companion object {
        const val NUMBERS_COUNT = 6
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
    }
}
