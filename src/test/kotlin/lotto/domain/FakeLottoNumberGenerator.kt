package lotto.domain

class FakeLottoNumberGenerator(
    private val list: List<Int> = listOf(1, 2, 3, 4, 5, 6)
) : LottoNumberGenerator {
    override fun generate(): List<Int> {
        return list
    }
}
