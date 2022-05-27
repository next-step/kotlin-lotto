package lotto

class Lottos(private val _lottos: List<Lotto>) {

    val get: List<Lotto>
        get() = _lottos.toList()
}
