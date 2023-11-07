package lotto

private const val LOTTO_PRICE = 1000

class LottoMachine(lottoGenerator: LottoGenerator) {

    fun create(money: Int): List<Any> {
        val size = money / LOTTO_PRICE
        return (0 until size).map { it }
    }
}
