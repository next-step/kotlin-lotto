package com.nextstep.lotto.domain

class LottoTicket(private val balls: List<LottoBall>) {

    init {
        require(balls.size == 6) { "6개의 LottoBall 을 입력받아야 합니다. size: ${balls.size}" }
        require(balls.toSet().size == 6) {
            println("사이즈" + setOf(balls).size)
            "중복된 LottoBall 을 입력받을 수 없습니다. numbers: $balls"
        }
    }

    fun getNumbers(): List<Int> = balls.map { it.number }
}
