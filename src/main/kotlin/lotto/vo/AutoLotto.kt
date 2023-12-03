package lotto.vo

class AutoLotto(private val price: Long, originLottos: List<Lotto> = listOf()) {
    val count: Int = initCount(price)
    val lottos: List<Lotto> = originLottos.ifEmpty { createLottoList() }

    private fun initCount(initPrice: Long): Int {
        require(initPrice >= 0) { "가격은 음수가 될 수 없습니다." }
        val count = initPrice / LOTTO_PRICE_PER_ONE
        require(count < Int.MAX_VALUE) { "로또 구매 개수는 ${Int.MAX_VALUE}개를 넘을 수 없습니다." }
        return count.toInt()
    }

    private fun createLottoList(): List<Lotto> {
        return (LOTTO_COUNT_START..count).map { Lotto() }
    }

    companion object {
        private const val LOTTO_PRICE_PER_ONE = 1000L
        private const val LOTTO_COUNT_START = 1L
    }
}
