package lotto.model

class Lottos(
    val lottos: List<Lotto>
) {
    val count = lottos.size

    fun findRanks(drawNumbers: DrawNumbers) = lottos.map { it.findRank(drawNumbers) }

    fun plus(other: Lottos) = Lottos(lottos.plus(other.lottos))
}
