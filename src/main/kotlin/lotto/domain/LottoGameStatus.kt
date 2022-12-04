package lotto.domain

import java.math.BigDecimal

data class LottoGameStatus(
    val cost: BigDecimal,
    val numberOfGames: Int,
    val numberOfManual: Int,
    val numberOfAuto: Int
)
