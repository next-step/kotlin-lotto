package lotto.domain

class LottoStore {

    fun purchaseAuto(money: Int): Lottoes {
        val quantity = money / LOTTO_COST
        val lottoes = arrayListOf<Lotto>()
        repeat(quantity) {
            lottoes.add(Lotto.generateAuto())
        }

        return Lottoes(lottoes)
    }

    fun purchaseManual(money: Int, numbers: List<Int>): Lottoes {
        val quantity = money / LOTTO_COST
        val lottoes = arrayListOf<Lotto>()
        repeat(quantity) {
            lottoes.add(Lotto.generateManual(numbers))
        }

        return Lottoes(lottoes)
    }

    companion object {
        const val LOTTO_COST = 1000
    }
}
