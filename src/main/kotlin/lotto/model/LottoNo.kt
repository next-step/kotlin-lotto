package lotto.model

import lotto.model.LottoMaker.Companion.LOTTO_NUMBER_END
import lotto.model.LottoMaker.Companion.LOTTO_NUMBER_START

class LottoNo private constructor(private val value: Int) {
    companion object {
        private val NUMBERS: Map<Int, LottoNo> = (LOTTO_NUMBER_START..LOTTO_NUMBER_END).associateWith(::LottoNo)

        fun from(value: Int): LottoNo {
            return NUMBERS.getOrElse(value) { throw IllegalArgumentException() }
        }

        fun to(lottoNo: LottoNo): Int {
            return lottoNo.value
        }
    }
}
