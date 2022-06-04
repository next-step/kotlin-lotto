package lotto.model

class Lottos(
    val lottos: List<Lotto>
) {
    val size = lottos.size

    fun findRanks(drawNumbers: DrawNumbers) = lottos.map { it.findRank(drawNumbers) }
}
