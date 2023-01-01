package com.nextstep.lotto.domain

class Lotto(private val numbers: List<LottoNumber>) {

    init {
        require(numbers.size == 6) { "6개의 LottoBall 을 입력받아야 합니다. size: ${numbers.size}" }
        require(numbers.toSet().size == 6) { "중복된 LottoBall 을 입력받을 수 없습니다. numbers: $numbers" }
    }

    constructor(vararg numbers: Int) : this(numbers.map(::LottoNumber))

    fun contains(number: LottoNumber): Boolean = numbers.contains(number)

    fun getNumbers(): List<Int> = numbers.map { it.value }
}
