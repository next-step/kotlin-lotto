package lotto.domain

data class Lottos(
    val lottos: List<Lotto>,
) {
    val quantity: Int = lottos.size

    fun match(winningLotto: Lotto): Results {
        val results = lottos.map { Result.of(it.compare(winningLotto)) }
        return Results(results)
    }
}
