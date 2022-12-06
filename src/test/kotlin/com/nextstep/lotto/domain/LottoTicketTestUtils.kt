package com.nextstep.lotto.domain

object LottoTicketTestUtils {
    fun createLottoNumbers(
        n1: Int,
        n2: Int,
        n3: Int,
        n4: Int,
        n5: Int,
        n6: Int
    ): Set<LottoNumber> =
        setOf(
            LottoNumber(n1),
            LottoNumber(n2),
            LottoNumber(n3),
            LottoNumber(n4),
            LottoNumber(n5),
            LottoNumber(n6)
        )
}
