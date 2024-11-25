package lotto

class Lottos(
    val lottos: List<Lotto>,
) {
    constructor(lottoCount: Int) : this(List(lottoCount) { Lotto() })

    operator fun plus(lottos: Lottos): Lottos = Lottos(lottos = this.lottos + lottos.lottos)
}
