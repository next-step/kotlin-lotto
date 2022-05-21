package lotto

class LottoNumberRandomGenerator : LottoNumberGenerator {
    override fun numberSet(): List<Int> {
        return lottoNumberList.shuffled().subList(0, 6).sorted()
    }

    companion object {
        private val lottoNumberList: Set<Int> = (1..45).toSet()
    }
}
