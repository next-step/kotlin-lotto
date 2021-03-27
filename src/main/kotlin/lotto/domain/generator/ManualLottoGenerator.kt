package lotto.domain.generator

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoNumberTokenizer

class ManualLottoGenerator(
    private val manualLottoNumbers: String
) : LottoGenerator {
    override fun generate(): Lotto {
        val lottoNumbers = LottoNumberTokenizer.tokenize(manualLottoNumbers).map { LottoNumber.from(it) }

        return Lotto.from(lottoNumbers)
    }
}
