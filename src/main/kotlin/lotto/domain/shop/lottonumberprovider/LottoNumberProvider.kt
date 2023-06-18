package lotto.domain.shop.lottonumberprovider

import lotto.domain.lottonumber.LottoNumber

interface LottoNumberProvider {

    fun getAllLottoNumbers(): List<LottoNumber>
}
