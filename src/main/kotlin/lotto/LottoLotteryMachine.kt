package lotto

object LottoLotteryMachine {

    fun draw(
        winningLotto: Lotto,
        lottos: List<Lotto>,
    ): LottoResult {
        val lottoResult = LottoResult()
        lottos.forEach { lotto ->
            val count = lotto.countMatch(winningLotto)
            val prize = Prize.from(count)
            lottoResult.add(prize)
        }
        return lottoResult
    }

}
