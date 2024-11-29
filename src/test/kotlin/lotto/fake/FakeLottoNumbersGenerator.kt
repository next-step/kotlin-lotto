package lotto.fake

import lotto.domain.lottonumber.LottoNumbersGenerator

class FakeLottoNumbersGenerator(
    private val lottoNumbers: List<Int>,
) : LottoNumbersGenerator {
    override fun generateLottoNumbers(): List<Int> = lottoNumbers
}
