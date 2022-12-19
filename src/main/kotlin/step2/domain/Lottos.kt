package step2.domain

class Lottos(val lottos: List<Lotto>) {

    fun getAnswerCountList(answer: Lotto): List<Int> {
        return lottos.map { lotto ->
            lotto.numbers.count {
                answer.numbers.contains(it)
            }
        }.filter { it > ANSWER_AVAILABLE_COUNT }
    }

    companion object {
        private const val ANSWER_AVAILABLE_COUNT = 0
    }
}
