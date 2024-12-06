package lotto.domain

import lotto.domain.data.Lotto
import lotto.domain.data.LottoNumber
import lotto.util.NumberGenerator
import lotto.util.RandomNumberGenerator

class LottoFactory(
    private val totalLottoCount: Int,
    private val numberGenerator: NumberGenerator = RandomNumberGenerator(),
) {
    fun createLottoList(): List<Lotto> {
        return List(totalLottoCount) {
            numberGenerator
                .getNumbers(Lotto.MIN_LOTTO_COUNT)
                .let { list -> Lotto(list.map { LottoNumber.from(it) }) }
        }

    }

    companion object {
        fun fromList(list: List<Int>): Lotto {
            return Lotto(list.map { LottoNumber(it) })
        }
    }
}
