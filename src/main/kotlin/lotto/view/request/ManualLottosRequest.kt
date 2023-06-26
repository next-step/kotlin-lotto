package lotto.view.request

import lotto.domain.LottoNumbers
import lotto.domain.LottoQuantity

class ManualLottosRequest(
    val lottoQuantity: LottoQuantity = LottoQuantity(0),
    val lottoNumbers: List<LottoNumbers> = emptyList(),
)
