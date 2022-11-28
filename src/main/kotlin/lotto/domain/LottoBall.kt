package lotto.domain

@JvmInline
value class LottoBall(val lottoBall: Int) {

    init {
        require(lottoBall in 1..49) { "비정상적인 로또볼입니다." }
    }
}
