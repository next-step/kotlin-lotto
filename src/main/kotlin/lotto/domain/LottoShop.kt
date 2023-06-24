package lotto.domain

private const val UNIT = 1000

object LottoShop {
    fun getNumberOfPurchase(amount: Int): Int {
        require(amount % UNIT == 0) {
            throw RuntimeException("$UNIT 단위로 입력해주세요.")
        }
        return amount / UNIT
    }

    private fun generateLottoNumbers(): List<Int> {
        val allNumbers = (1..45).toList()
        val lottoNumbers = allNumbers.shuffled().subList(0, 6)
        return lottoNumbers.sorted()
    }

    fun getLottoNumbers(count: Int): List<List<Int>> {
        return List(count) { generateLottoNumbers() }
    }
}
