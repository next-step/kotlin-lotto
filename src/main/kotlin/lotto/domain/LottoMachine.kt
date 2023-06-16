package lotto.domain

object LottoMachine {

    private val LOTTO_RANGE_NUMBERS = (1..45).map { it }
    const val LOTTO_NUMBER = 6

    var lottoCount = 0
        private set

    var buyedLotto = mutableListOf<List<Int>>()
        private set

    fun buyLotto(amount: Int) {
        lottoCount = amount/1000

        repeat(lottoCount) {
            buyedLotto.add(LOTTO_RANGE_NUMBERS.shuffled().take(LOTTO_NUMBER))
        }
    }
}
