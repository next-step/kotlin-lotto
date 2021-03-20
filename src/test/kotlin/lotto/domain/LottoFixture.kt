package lotto.domain

import lotto.domain.result.LottoRank

fun createLotto(num1: Int, num2: Int, num3: Int, num4: Int, num5: Int, num6: Int) =
    LottoTicket(
        setOf(
            LottoNumber(num1),
            LottoNumber(num2),
            LottoNumber(num3),
            LottoNumber(num4),
            LottoNumber(num5),
            LottoNumber(num6),
        )
    )

fun createLottoResult() = mutableMapOf(
    Pair(LottoRank.FIRST, 0),
    Pair(LottoRank.SECOND, 0),
    Pair(LottoRank.THIRD, 0),
    Pair(LottoRank.FOURTH, 0),
    Pair(LottoRank.NONE, 0)
)
