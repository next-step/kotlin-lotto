package lotto.domain

@JvmInline
value class LottoAnswer(
    private val answer: List<Int>
) {

    fun match(inputLottos: List<Lotto>): Map<Int, Int> {
        return inputLottos
            .map { innerMatch(it) }
            .groupingBy { it }
            .eachCount()
    }

    private fun innerMatch(inputLotto: Lotto): Int {
        return inputLotto.numbers.count { outer -> answer.find { outer == it } != null }
    }

    companion object {
        fun create(answer: List<Int>) = LottoAnswer(answer)
    }
}
