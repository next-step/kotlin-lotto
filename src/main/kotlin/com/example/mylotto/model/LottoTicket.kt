package com.example.mylotto.model

class LottoTicket(
    val numbers: Set<LottoNumber>,
) {
    constructor() : this(
        (1..45)
            .shuffled()
            .take(6)
            .sorted()
            .map { LottoNumber(it) }
            .toSet(),
    )
}
