package simulator.lotto

class LottoResult(lottos: List<Lotto>, winningLotto: Lotto) {
    var first: Int = 0
        private set
    var second: Int = 0
        private set
    var third: Int = 0
        private set
    var fourth: Int = 0
        private set

    init {
        lottos.forEach {
            ranking(it, winningLotto)
        }
    }


    fun money(): Int {
        return FIRST_PRIZE * first + SECOND_PRIZE * second + THIRD_PRIZE * third + FOURTH_PRIZE * fourth
    }

    private fun ranking(lotto: Lotto, winningLotto: Lotto) {
        when (lotto.match(winningLotto)) {
            6 -> this.first++
            5 -> this.second++
            4 -> this.third++
            3 -> this.fourth++
        }
    }

    companion object {
        const val FIRST_PRIZE = 2000000000
        const val SECOND_PRIZE = 1500000
        const val THIRD_PRIZE = 50000
        const val FOURTH_PRIZE = 5000
    }
}
