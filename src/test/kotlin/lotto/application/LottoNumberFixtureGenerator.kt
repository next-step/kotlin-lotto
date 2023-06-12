package lotto.application

import lotto.domain.LottoNumber
import lotto.domain.LottoNumbersFixtureMaker
import lotto.domain.generator.LottoNumbersGenerator

internal class LottoNumberFixtureGenerator(var fixedList: List<Int>) : LottoNumbersGenerator {
    override fun generate(): LinkedHashSet<LottoNumber> =
        LottoNumbersFixtureMaker.createLottoNumbers(fixedList)

}
