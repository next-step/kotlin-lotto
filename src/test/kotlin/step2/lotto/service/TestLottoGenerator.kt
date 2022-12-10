package step2.lotto.service

class TestLottoGenerator : LottoGenerator {
    override fun generate(): List<Int> = listOf(1, 2, 3, 4, 5, 6)
}
