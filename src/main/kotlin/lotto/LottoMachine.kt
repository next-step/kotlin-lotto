package lotto

class LottoMachine(private val buyCount: Int) {
    fun issue(): List<Lotto> {
        return List(buyCount) { Lotto { generateNumbers(Lotto.LOTTO_NUMBER_COUNT) } }
    }

    fun verify(lastNumber: String, lottos: List<Lotto>): List<StatResult> {
        val checker = Checker(lastNumber)
        return Stat(lottos, checker).sumRecords
    }
}
