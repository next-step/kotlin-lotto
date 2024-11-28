package lotto.domain

class Lottos private constructor(
    val lottos: List<DefaultLotto>,
) {
    val quantity: Int = lottos.size

    fun match(winningLotto: WinningLotto): Results {
        val results = lottos.map(winningLotto::compare)
        return Results(results)
    }

    companion object {
        fun from(
            autoLottos: List<DefaultLotto>,
            manualLottos: List<DefaultLotto> = emptyList(),
        ): Lottos {
            return Lottos(autoLottos + manualLottos)
        }
    }
}
