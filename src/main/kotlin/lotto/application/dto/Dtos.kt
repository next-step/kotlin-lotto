// ktlint-disable filename
package lotto.application.dto

import lotto.domain.WinningResult

data class LottoResult(
    val winningPrice: Double,
    val winningResults: Map<WinningResult, Int>
)
