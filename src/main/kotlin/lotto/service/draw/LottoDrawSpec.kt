package lotto.service.draw

import lotto.domain.Lotto

data class LottoDrawSpec(
    val lottos: List<Lotto>,
    val winningNumbers: List<Int>,
    val purchaseAmount: Long,
)
