package lotto.domain.shop.lottonumberprovider

import lotto.domain.lottonumber.LottoNumber

class MockLottoNumberProvider(
    private val fixedLottoNumbers: List<LottoNumber>,
) : LottoNumberProvider {

    override fun getAllLottoNumbers(): List<LottoNumber> {
        return fixedLottoNumbers
    }
}
