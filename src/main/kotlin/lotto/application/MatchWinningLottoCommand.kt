package lotto.application

import lotto.domain.Lotto

data class MatchWinningLottoCommand(
    val userLottos: List<Lotto>,
    val winningLotto: Lotto,
)