package lotto.domain

@JvmInline
value class LottoAnswer(
    private val answer: List<Int>
) {

    fun match(inputLottos: List<Lotto>): Map<MatchCount, Int> {
        return inputLottos
            .map { innerMatch(it) }
            .groupingBy { it }
            .eachCount()
    }

    private fun innerMatch(inputLotto: Lotto): Int {
        return inputLotto.numbers.count { outer -> isAnswerNumberMatch(outer) }
    }

    private fun isAnswerNumberMatch(outer: Int): Boolean {
        return answer.find { outer == it } != null
    }

    companion object {
        fun create(answer: List<Int>) = LottoAnswer(answer)
    }
}
