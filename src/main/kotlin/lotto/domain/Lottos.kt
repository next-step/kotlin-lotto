package lotto.domain

data class Lottos(
    val lottoList: List<Lotto>,
) : Iterable<Lotto> {
    val size: Int = lottoList.size

    override fun iterator(): Iterator<Lotto> =
        lottoList.iterator()
}

class LottosResult private constructor(
    val lottos: Lottos,
    val manualLottoSize: Int = 0,
    val autoLottoSize: Int = 0
) : Iterable<Lotto> {

    override fun iterator(): Iterator<Lotto> =
        lottos.iterator()

    companion object {
        fun of(manualLottos: Lottos, autoLottos: Lottos) = LottosResult(
            Lottos(manualLottos.lottoList + autoLottos.lottoList),
            manualLottos.size,
            autoLottos.size
        )
    }
}
