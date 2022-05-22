package lotto.domain

class FixedLottoGenerator(
    private val fixedLotto: MutableList<Lotto>
) : LottoGenerator {
    override fun generate(): Lotto {
        return fixedLotto.removeFirst()
    }
}
