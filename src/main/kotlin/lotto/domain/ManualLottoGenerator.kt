package lotto.domain

class ManualLottoGenerator(private val manualNumbers: List<Int>) : LottoGenerator {
    override fun generateLotto(): Lotto = Lotto.fromInts(manualNumbers)
}
