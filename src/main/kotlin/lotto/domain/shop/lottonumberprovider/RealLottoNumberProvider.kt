package lotto.domain.shop.lottonumberprovider

import lotto.domain.lottonumber.LottoNumber

class RealLottoNumberProvider : LottoNumberProvider {

    override fun getAllLottoNumbers(): List<LottoNumber> {
        return LottoNumber.allLottoNumbers()
    }
}
