package lotto

class Lottos(lottos: List<Lotto>) {
    private val _lottos: MutableList<Lotto> = lottos.toMutableList()
    val lottos: List<Lotto>
        get() = _lottos.toList()
}
