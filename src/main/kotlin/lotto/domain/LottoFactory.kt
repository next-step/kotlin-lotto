package lotto.domain

import lotto.domain.model.Lotto
import lotto.domain.model.LottoNumber
import lotto.util.NumberGenerator
import lotto.util.RandomNumberGenerator

class LottoFactory(
    private val totalLottoCount: Int,
    private val numberGenerator: NumberGenerator = RandomNumberGenerator(),
) {
    fun createLottoList(): List<Lotto> {
        return List(totalLottoCount) {
            numberGenerator
                .getNumbers(Lotto.LOTTO_COUNT)
                .let { list -> Lotto(list.map { LottoNumber.from(it) }) }
        }
    }

    companion object {
        fun fromList(list: List<Int>): Lotto {
            return Lotto(list.map { LottoNumber(it) })
        }
    }
}
