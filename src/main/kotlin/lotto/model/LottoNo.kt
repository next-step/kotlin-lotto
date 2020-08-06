package lotto.model

import lotto.model.LottoMaker.Companion.LOTTO_NUMBER_END
import lotto.model.LottoMaker.Companion.LOTTO_NUMBER_START
import java.lang.RuntimeException

data class LottoNo(val number: String) {
    init {
        try {
            if (number.toInt() < LOTTO_NUMBER_START || number.toInt() > LOTTO_NUMBER_END) throw RuntimeException("로또의 범위는 1 이상 45 이하입니다.")
        } catch (e: RuntimeException) {
            throw RuntimeException("로또는 숫자로만 이루어질 수 있습니다.")
        }
    }
}
