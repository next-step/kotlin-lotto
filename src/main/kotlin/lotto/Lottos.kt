package lotto

class Lottos(
    val lottos: List<Lotto>,
) {
    init {
        require(isDistinct()) { "로또 번호는 중복이 없어야 합니다. " }
    }

    constructor(lottoCount: Int) : this(List(lottoCount) { Lotto() })

    operator fun plus(lottos: Lottos): Lottos = Lottos(lottos = this.lottos + lottos.lottos)

    private fun isDistinct(): Boolean = lottos.distinct().size == lottos.size
}
