package lotto

object LottoShop {
    private const val LOTTO_PRICE = 1000
    
    fun sellLottos(cash: Int): List<Lotto> {
        val amountOfLotto = cash / LOTTO_PRICE
        val generatedLottos = mutableListOf<Lotto>()
        repeat(amountOfLotto) {
            generatedLottos.add(generateLotto())
        }

        return generatedLottos
    }

    private fun generateLotto(): Lotto {
        val lottoNums = (1..45).shuffled().subList(0, 6)

        return Lotto.from(lottoNums)
    }
}
