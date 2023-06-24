package lotto.domain.response

import lotto.domain.Lottos

class GeneratedLottosResponse(
    val manualLottos: Lottos,
    val autoLottos: Lottos,
) {
    val lottos: Lottos
        get() = manualLottos + autoLottos
}
