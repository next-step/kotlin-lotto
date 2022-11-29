package lotto.domain

@JvmInline
value class LottoBall(val lottoBall: Int) {
    init {
        require(lottoBall in LOTTOBALL_MIN..LOTTOBALL_MAX) { "비정상적인 로또볼입니다." }
    }

    companion object {
        const val LOTTOBALL_MIN = 1
        const val LOTTOBALL_MAX = 49
    }
}
