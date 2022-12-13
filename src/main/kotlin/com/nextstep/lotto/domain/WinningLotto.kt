package com.nextstep.lotto.domain

class WinningLotto(private val numbers: List<LottoNumber>) {

    init {
        require(numbers.size == 6) { "당첨 번호는 6개여야 합니다. size: ${numbers.size}" }
        require(numbers.toSet().size == 6) { "당첨 번호에는 중복이 없어야 합니다. numbers: $numbers" }
    }

    constructor(vararg numbers: Int): this(numbers.map(::LottoNumber))
}
