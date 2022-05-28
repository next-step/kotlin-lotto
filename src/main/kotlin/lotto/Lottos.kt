package lotto

class Lottos(private val _lottos: List<Lotto>) {

    val lottos: List<Lotto>
        get() = _lottos.toList()
}
