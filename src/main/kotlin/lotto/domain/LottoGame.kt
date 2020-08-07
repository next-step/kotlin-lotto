package lotto.domain

class LottoGame(private val money: Money) {
    private val totalNumbers = make45Numbers()
    val lottoList = makeLotto()

    private fun make45Numbers(): List<String> = (FIRST_NUMBER..LAST_NUMBER).map { it.toString() }

    private fun makeLotto(): List<Lotto> {
        val amount = money.getAmount()
        return (FIRST_NUMBER..amount).map { Lotto(makeRandomNumbers()) }
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
        const val FIRST_NUMBER = 1
        const val LAST_NUMBER = 45
    }
}
