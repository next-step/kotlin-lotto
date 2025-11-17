package com.example.mylotto.model

import com.example.mylotto.constant.LottoConstant

class LottoTicket(
    val numbers: Set<LottoNumber>,
) {
    constructor() : this(
        (1..LottoConstant.LOTTO_NUMBER_MAX)
            .shuffled()
            .take(LottoConstant.LOTTO_NUMBER_SIZE)
            .sorted()
            .map { LottoNumber(it) }
            .toSet(),
    )
}
