package lotto.domain.response

import lotto.domain.Lottos

class LottosGenerateResponse(
    val lottos: Lottos,
) {
    val manualLottos = lottos.manual
    val autoLottos = lottos.auto
}
