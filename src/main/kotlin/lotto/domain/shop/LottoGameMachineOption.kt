package lotto.domain.shop

import lotto.domain.lottonumber.LottoNumbers

sealed class LottoGameMachineOption {

    data class Self(val lottoNumbers: LottoNumbers) : LottoGameMachineOption()

    object Auto : LottoGameMachineOption()
}
