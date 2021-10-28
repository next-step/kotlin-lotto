package lotto

class Lottos(private val money: Int) {

    private var purchasedLottos = mutableListOf<Lotto>()

    fun buy(): List<Lotto> {
        purchasedLottos = MutableList(money / LOTTO_PRICE) { Lotto() }
        return purchasedLottos.toList()
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}