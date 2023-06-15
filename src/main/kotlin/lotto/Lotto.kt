package lotto

class Lotto {

    fun buyLotto(money: Int): List<List<Int>> {
        val lottoBundle: MutableList<List<Int>> = mutableListOf()

        val count = money / ONE_PRICE
        repeat(count) {
            lottoBundle.add(generateNumbers())
        }
        return lottoBundle.toList()
    }

    private fun generateNumbers(): List<Int> {
        val numberSet = mutableSetOf<Int>()
        do {
            numberSet.add(LottoNumber().getLottoNumber())
        } while (numberSet.size < NUMBER_COUNT)
        return numberSet.sorted()
    }

    companion object {
        private const val ONE_PRICE: Int = 1000
        private const val NUMBER_COUNT: Int = 6
    }
}
