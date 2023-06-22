package lotto.domain

data class Lottos(
    val lottoList: List<Lotto>,
) : Iterable<Lotto> {
    val size: Int = lottoList.size

    override fun iterator(): Iterator<Lotto> =
        lottoList.iterator()
}

data class LottosResult(
    val lottos: Lottos,
    val manualLottoSize: Int = 0,
    val autoLottoSize: Int = 0
) : Iterable<Lotto> {
    constructor(manualLottos: Lottos, autoLottos: Lottos) : this(
        Lottos(manualLottos.lottoList + autoLottos.lottoList),
        manualLottos.size,
        autoLottos.size
    )

    override fun iterator(): Iterator<Lotto> =
        lottos.iterator()
}
