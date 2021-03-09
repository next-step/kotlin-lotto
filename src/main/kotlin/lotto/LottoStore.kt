package lotto

class LottoStore {

    fun purchaseAuto(money: Int): Lottos {
        val quantity = money / LOTTO_COST
        val lottos = arrayListOf<Lotto>()
        repeat(quantity) {
            lottos.add(Lotto.generateAuto())
        }

        return Lottos(lottos)
    }

    fun purchaseManual(money: Int, numbers: List<Int>): Lottos {
        val quantity = money / LOTTO_COST
        val lottos = arrayListOf<Lotto>()
        repeat(quantity) {
            lottos.add(Lotto.generateManual(numbers))
        }

        return Lottos(lottos)
    }

    companion object {
        const val LOTTO_COST = 1000
    }
}
