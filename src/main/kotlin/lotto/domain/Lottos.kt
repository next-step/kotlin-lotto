package lotto.domain

data class Lottos(
    val lottos: List<DefaultLotto>,
) {
    val quantity: Int = lottos.size

    fun match(winningLotto: WinningLotto): Results {
        val results = lottos.map(winningLotto::compare)
        return Results(results)
    }
}
