package lotto.domain

class FakeLottoNumberGenerator : LottoNumberGenerator {
    override fun generate(): List<Int> {
        return listOf(1, 2, 3, 4, 5, 6)
    }
}
