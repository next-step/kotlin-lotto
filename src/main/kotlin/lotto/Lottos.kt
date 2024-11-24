package lotto

class Lottos(
    val lottos: List<Lotto>,
) {
    constructor(lottoCount: Int) : this(List(lottoCount) { Lotto() })
}
