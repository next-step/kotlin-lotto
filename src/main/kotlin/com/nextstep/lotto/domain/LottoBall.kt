package com.nextstep.lotto.domain



data class LottoBall(private val number: Int) {
    init {
        require(number in 1..45) { "로또 번호는 1에서 45 사이의 숫자여야 합니다. number: $number" }
    }

    companion object {
        private val lottoBalls: List<LottoBall> = (1..45).map { LottoBall(it) }
    }
}
