package lotto.domain.response

import lotto.domain.Lottos

class LottosGenerateResponse(
    val manualLottos: Lottos,
    val autoLottos: Lottos,
) {
    val lottos: Lottos
        get() = manualLottos + autoLottos
}
