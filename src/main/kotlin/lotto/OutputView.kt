package lotto

object OutputView {
    private const val LOTTO_PRICE = 1000

    fun printResult(lottoResult: LottoResult) {
        println("당첨 통계")
        println("---------")
        printLottoResult(lottoResult)
        println(lottoResult.totalPrize)
        println("총 수익률은 ${lottoResult.totalPrize / lottoResult.lottoCount / LOTTO_PRICE * 100.0}%입니다.")
    }

    private fun printLottoResult(lottoResult: LottoResult) {
        lottoResult.lottoRanking
            .filter { it.key.amount.value > 0 }
            .toSortedMap(compareBy { it.amount.value })
            .forEach { (prize, count) ->
                println("${prize.sameCounts[0]}개 일치 (${prize.amount.value}원)- ${count}개")
            }
    }

    fun printLottos(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach { printLotto(it) }
    }

    private fun printLotto(lotto: Lotto) {
        println(lotto.lottoNumbers.map { it.value }.joinToString(separator = ", ", prefix = "[", postfix = "]"))
    }
}
