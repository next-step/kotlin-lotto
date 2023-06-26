package step2Lotto.domain

import step2Lotto.domain.dto.Lotto

interface LottoGenerator {
    fun createLotto(): Lotto
}

class AutoLottoGenerator : LottoGenerator {
    override fun createLotto(): Lotto {
        return Lotto(getRandomLottoNumbers())
    }

    private fun getRandomLottoNumbers(): List<LottoNumber> {
        return LottoNumber.NUMBERS.shuffled()
            .subList(0, 6)
            .sorted()
            .map { LottoNumber(it) }
    }
}
