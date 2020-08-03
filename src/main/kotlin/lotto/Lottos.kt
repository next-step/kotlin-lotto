package lotto

class Lottos(private val lottos: List<Lotto>) {

    fun findResults(): Results {
        return Results(lottos.map { it.findResult() })
    }

    override fun toString(): String {
        return lottos.joinToString("\r\n")
    }
}
