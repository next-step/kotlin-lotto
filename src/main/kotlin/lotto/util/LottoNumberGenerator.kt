package lotto.util

interface LottoNumberGenerator {

    fun numberSet(): List<Int>

    class Fake(
        private val lottoNumberList: List<Int>
    ) : LottoNumberGenerator {
        override fun numberSet(): List<Int> {
            return lottoNumberList.sorted()
        }
    }
}
