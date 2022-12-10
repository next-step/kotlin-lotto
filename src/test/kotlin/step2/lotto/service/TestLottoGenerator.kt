package step2.lotto.service

class TestLottoGenerator : LottoGenerator {
    override fun generate(): Set<Int> = setOf(1, 2, 3, 4, 5, 6)
}
