package lotto

class LottoGame(val lottoList: List<Lotto>, val winningNumbers: Set<Int>) {
    fun getResult(): LottoGameResult {
        val rewards = lottoList
            .map { it.match(winningNumbers) }
            .mapNotNull { LottoReward.valueOf(it) }
            .sorted()

        return LottoGameResult(rewards)
    }
}
