package lotto.dto

import lotto.domain.LottoNumber

data class WinningLottoRequest(
    val winningLottoNumbers: List<LottoNumber>,
    val bonusNumber: LottoNumber
)
