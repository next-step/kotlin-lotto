package lotto.domain

class LottoGame(private val money: Int) {
    private val totalNumbers = make45Numbers()
    val lottoList = makeLotto(money)

    private fun make45Numbers(): List<String> {
        val numbers = mutableListOf<Int>()
        for (number in START_NUMBER..LAST_NUMBER) {
            numbers.add(number)
        }
        return numbers.map { it.toString() }
    }

    private fun makeLotto(money: Int): List<Lotto> {
        val amount = money / 1_000
        val lotto = mutableListOf<Lotto>()
        for (number in START_NUMBER..amount) {
            lotto.add(Lotto(makeRandomNumbers()))
        }
        return lotto
    }

    private fun makeRandomNumbers(): List<String> = totalNumbers.shuffled().take(6)

    fun getRank(correctLotto: Lotto, bonusBall: BonusBall): Rank {
        val rank = Rank()
        lottoList.forEach { rank.addRank(it.getCountMatch(correctLotto.numbers), it.isCorrect(bonusBall.number)) }
        return rank
    }

    fun getResult(rank: Rank): Result = Result(money, rank.ranks)

    companion object {
        const val START_NUMBER = 1
        const val LAST_NUMBER = 45
    }
}
