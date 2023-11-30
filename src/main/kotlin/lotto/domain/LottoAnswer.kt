package lotto.domain

data class LottoAnswer(
    private val answer: List<Int>,
    private val bonusNumber: Int
) {

    fun match(inputLottos: List<Lotto>): Map<MatchCount, Int> {
        return inputLottos
            .map { innerMatch(it) }
            .groupingBy { it }
            .eachCount()
    }

    private fun innerMatch(inputLotto: Lotto): MatchCount {
        val count = inputLotto.numbers.count { outer -> isAnswerNumberMatch(outer) }
        val isBonusMatch = isBonusMatch(inputLotto)
        return MatchCount.of(count, isBonusMatch)
    }

    private fun isBonusMatch(inputLotto: Lotto): Boolean {
        return inputLotto.numbers.find { bonusNumber == it } != null
    }

    private fun isAnswerNumberMatch(outer: Int): Boolean {
        return answer.find { outer == it } != null
    }

    companion object {
        fun create(answer: List<Int>, bonusNumber: Int) = LottoAnswer(answer, bonusNumber)
    }
}
