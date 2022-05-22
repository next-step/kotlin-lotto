package lotto

class LottoStore(private val money: Int) {
    val lottoCount = money / EACH_LOTTO_PRICE

    companion object {
        private const val EACH_LOTTO_PRICE = 1000
    }
}