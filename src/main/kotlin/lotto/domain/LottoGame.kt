package lotto.domain

class LottoGame(
    private val lottos: List<Lotto>,
    private val winningLotto: Lotto,
    private val bonusNumber: LottoNumber
) {

    private val ranks = lottos.map {
        Rank.of(it.countOfMatch(winningLotto), bonusNumber in it.numbers)
    }

    private val prize = ranks.sumOf { it.prize }

    val profit: Double = prize / (lottos.size * LOTTO_PRICE)

    fun countOfRank(rank: Rank): Int {
        return ranks.count { it == rank }
    }

    companion object {
        private const val LOTTO_PRICE = 1_000
    }
}
