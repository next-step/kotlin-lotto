package lotto.domain

class LottoGame(private val amount: Amount, private val manualLottoList: List<Lotto> = listOf()) {
    val lottoList = makeLotto()

    private fun makeLotto(): List<Lotto> {
        val totalLotto = listOf(manualLottoList, (FIRST_NUMBER..amount.auto).map { Lotto(makeRandomNumbers()) })
        return totalLotto.flatten()
    }

    private fun makeRandomNumbers(): Set<Int> = (FIRST_NUMBER..LAST_NUMBER).shuffled().take(Lotto.LOTTO_HAS_NUMBERS).toSet()

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
