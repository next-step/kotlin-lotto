package lotto

class LottoStore {

    fun purchaseAuto(money: Int): List<Lotto> {
        val quantity = money / LOTTO_COST
        val lottos = arrayListOf<Lotto>()
        repeat(quantity) {
            lottos.add(Lotto.generateAuto())
        }

        return lottos
    }

    fun purchaseManual(money: Int, numbers: List<Int>): List<Lotto> {
        val quantity = money / LOTTO_COST
        val lottos = arrayListOf<Lotto>()
        repeat(quantity) {
            lottos.add(Lotto.generateManual(numbers))
        }

        return lottos
    }

    companion object {
        const val LOTTO_COST = 1000
    }
}
