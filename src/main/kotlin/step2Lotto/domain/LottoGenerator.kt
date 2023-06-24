package step2Lotto.domain

import step2Lotto.domain.dto.Lotto

interface LottoGenerator {
    fun execute(): Lotto
}

class AutoLottoGenerator : LottoGenerator {
    override fun execute(): Lotto {
        return Lotto(LottoNumber.NUMBERS.shuffled().subList(0, 5).sorted())
    }
}
