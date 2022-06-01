package lotto

class Lottos {

    private val _lottos: MutableList<Lotto> = mutableListOf()

    val lotto: List<Lotto>
        get() = _lottos.toList()

    fun add(lotto: Lotto) {
        _lottos.add(lotto)
    }
}
