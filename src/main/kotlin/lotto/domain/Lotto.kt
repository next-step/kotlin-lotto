package lotto.domain

data class Lotto(val lotto: Set<LottoBall>) {

    init {
        require(lotto.size == LOTTO_SIZE) { "비정상적인 로또입니다." }
    }

    fun matchNumberWith(winningLotto: Lotto): Int = this.lotto.intersect(winningLotto.lotto).size
    fun containsBall(lottoBall: LottoBall) = this.lotto.contains(lottoBall)

    companion object {
        const val LOTTO_SIZE = 6
        fun of(lotto: List<Int>): Lotto {
            return Lotto(
                lotto.map {
                    LottoBall(it)
                }.toSet()
            )
        }
    }
}
