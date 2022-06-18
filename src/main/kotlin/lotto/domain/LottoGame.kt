package lotto.domain

class LottoGame(
    lottos: List<Lotto>,
    private val winningLotto: Lotto,
    private val bonusNumber: LottoNumber
) {

    init {
        require(bonusNumber !in winningLotto.numbers) { "Bonus number[$bonusNumber] must not be in winning numbers." }
    }

    private val ranks = lottos.map {
        Rank.of(countOfMatch = it.countOfMatch(winningLotto), matchedBonus = bonusNumber in it.numbers)
    }

    private val prize = ranks.sumOf { it.prize }

    val profit: Double = prize / (lottos.size * LOTTO_PRICE)

    val result = LottoGameResult(ranks, profit)

    fun countOfRank(rank: Rank): Int {
        return ranks.count { it == rank }
    }

    companion object {
        private const val LOTTO_PRICE = 1_000
    }
}
