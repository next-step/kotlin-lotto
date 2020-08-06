package lotto.domain

class LottoGame(money: Money) {
    private val totalNumbers = make45Numbers()
    val lottoList = makeLotto(money.money)

    private fun make45Numbers(): List<String> = Array(LAST_NUMBER) { it + 1 }.map { it.toString() }

    private fun makeLotto(money: Int): List<Lotto> {
        val amount = money / ONE_LOTTO_PRICE
        return Array(amount) { Lotto(makeRandomNumbers()) }.toList()
    }

    private fun makeRandomNumbers(): List<String> = totalNumbers.shuffled().take(6)

    fun getRank(winningLotto: WinningLotto): Rank {
        val rank = Rank()
        lottoList.forEach {
            rank.addRank(winningLotto.match(it))
        }
        return rank
    }

    companion object {
        const val LAST_NUMBER = 45
        const val ONE_LOTTO_PRICE = 1_000
    }
}
