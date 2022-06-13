package lotto.domain

class LottoGame(
    private val lottos: List<Lotto>,
    private val winningLotto: Lotto,
    private val bonusNumber: LottoNumber
) {

    private val prize = lottos.sumOf { lotto ->
        Rank.of(lotto.matchedNumber(winningLotto), bonusNumber in lotto.numbers).prize
    }.toString()

    val profit: Double = prize.toDouble() / (lottos.size * LOTTO_PRICE)

    fun rank(i: Int): Int {
        return lottos.filter { lotto ->
            lotto.matchedNumber(winningLotto) == i
        }.size
    }

    companion object {
        private const val LOTTO_PRICE = 1_000
    }
}
