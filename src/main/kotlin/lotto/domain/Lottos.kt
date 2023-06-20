package lotto.domain

data class Lottos(
    val lottoList: List<Lotto>,
    val manualLottoSize: Int = 0,
    val autoLottoSize: Int = 0
) : Iterable<Lotto> {
    val size: Int = lottoList.size

    constructor(manualLottos: Lottos, autoLottos: Lottos) : this(
        manualLottos.lottoList + autoLottos.lottoList,
        manualLottos.size,
        autoLottos.size
    )

    override fun iterator(): Iterator<Lotto> =
        lottoList.iterator()
}
