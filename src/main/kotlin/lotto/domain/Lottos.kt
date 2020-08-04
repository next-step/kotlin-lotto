package lotto.domain

class Lottos(private val lottos: List<Lotto>) {

    fun getResults(): Results {
        return Results(lottos.map { it.getResult() })
    }

    override fun toString(): String {
        return lottos.joinToString("\r\n")
    }
}
