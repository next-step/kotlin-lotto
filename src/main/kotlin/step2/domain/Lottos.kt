package step2.domain

class Lottos(private val lottos: List<Lotto>) {

    fun getAnswerCountList(answer: Lotto): List<Int> {
        return lottos.map { lotto ->
            lotto.numbers.count { answer.numbers.contains(it) }
        }.filter { it > 0 }
    }
}
