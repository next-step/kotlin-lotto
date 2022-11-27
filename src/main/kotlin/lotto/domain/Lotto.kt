package lotto.domain

class Lotto(val lotto: List<LottoBall>) {

    init {
        require(lotto.size == LOTTO_SIZE) { "비정상적인 로또입니다." }
    }
    fun matchNumberWith(winningLotto: Lotto): Int {
        return this.lotto.map {
            if (winningLotto.contains(it)) 1 else 0
        }.sum()
    }

    private fun contains(lottoBall: LottoBall): Boolean {
        lotto.find { it == lottoBall }?.let {
            return true
        }
        return false
    }


    companion object {
        const val LOTTO_SIZE = 6

        fun with(lotto:List<Int>) : Lotto {
           return Lotto(lotto.map {
                LottoBall(it)
            })
        }
    }

}
