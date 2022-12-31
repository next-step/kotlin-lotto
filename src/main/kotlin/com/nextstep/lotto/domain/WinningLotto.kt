package com.nextstep.lotto.domain

class WinningLotto(private val winninNumbers: List<LottoNumber>) {

    init {
        require(winninNumbers.size == 6) { "당첨 번호는 6개여야 합니다. size: ${winninNumbers.size}" }
        require(winninNumbers.toSet().size == 6) { "당첨 번호에는 중복이 없어야 합니다. numbers: $winninNumbers" }
    }

    constructor(vararg numbers: Int): this(numbers.map(::LottoNumber))

    fun match(lotto: Lotto): Int {
        return winninNumbers.count { lotto.contains(it) }
    }
}
