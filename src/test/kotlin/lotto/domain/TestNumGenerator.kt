package lotto.domain

class TestNumGenerator : LottoNumGenerator {
    override fun getNums(): List<Int> {
        return listOf(1, 2, 3, 4, 5, 6)
    }
}

class BigNumGenerator : LottoNumGenerator {
    override fun getNums(): List<Int> {
        return listOf(1, 2, 3, 4, 5, 46)
    }
}
class FiveNumGenerator : LottoNumGenerator {
    override fun getNums(): List<Int> {
        return listOf(1, 2, 3, 4, 5)
    }
}