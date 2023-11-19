package lotto

object LottoMachine {
    private val LOTTO_PRICE = 1000
    fun generateLotto(amount: Int, lottoNumberGenerator: LottoNumberGenerator): List<Lotto> {
        val lottoCount = amount / LOTTO_PRICE
        val lottoList = mutableListOf<Lotto>()

        repeat(lottoCount) {
            val lotto = Lotto.from(lottoNumberGenerator)
            lottoList.add(lotto)
        }
        return lottoList
    }


}
