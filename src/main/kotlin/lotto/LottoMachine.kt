package lotto

const val MIN_PRIZE_COUNT = 3

class LottoMachine {

    private fun generateRandomLottoNumbers(): List<Int> = LOTTO_NUMBERS.shuffled().subList(0, 6)

    fun calculateStat(lottoes: List<Lotto>, prizeLotto: Lotto): List<Pair<PrizeMoney, Int>> {
        return lottoes
            .groupingBy {
                it.equalsCount(prizeLotto)
            }.eachCount().filter { it.key >= MIN_PRIZE_COUNT }.map { Pair(PrizeMoney.generate(it.key), it.value) }
    }

    fun createLotto(lottoNumbers: List<Int>): Lotto = Lotto(lottoNumbers)

    fun createLottoes(lottoCount: Int): List<Lotto> {
        var lottoes = mutableListOf<Lotto>()
        repeat(lottoCount) {
            lottoes.add(Lotto(generateRandomLottoNumbers()))
        }
        return lottoes
    }

    companion object {
        val LOTTO_NUMBERS = (MIN_NUMBER..MAX_NUMBER).toList()
    }
}
