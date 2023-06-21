package lotto.domain.shop

import lotto.domain.lottonumber.LottoNumbers

fun autoLottoGame(lottoNumbers: LottoNumbers): LottoGame {
    return LottoGame(
        type = LottoGameType.AUTO,
        lottoNumbers = lottoNumbers
    )
}
