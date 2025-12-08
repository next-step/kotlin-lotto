package com.example.mylotto.model

import com.example.mylotto.constant.LottoConstant

class LottoTicket private constructor(
    val numbers: Set<LottoNumber>,
) {
    companion object {
        fun ofAutomatic(): LottoTicket =
            LottoTicket(
                (1..LottoConstant.LOTTO_NUMBER_MAX)
                    .shuffled()
                    .take(LottoConstant.LOTTO_NUMBER_SIZE)
                    .sorted()
                    .map(LottoNumber::of)
                    .toSet(),
            )

        fun ofManual(numbers: Set<LottoNumber>): LottoTicket {
            require(numbers.size == LottoConstant.LOTTO_NUMBER_SIZE) { "로또 티켓은 ${LottoConstant.LOTTO_NUMBER_SIZE}개 숫자여야 합니다." }
            return LottoTicket(numbers)
        }
    }
}
