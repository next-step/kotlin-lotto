package lotto.domain

class TestNumGenerator : LottoNumGenerator {
    override fun getNums(): List<Int> {
        return listOf(1, 2, 3, 4, 5, 6)
    }
}