package lotto.model

import lotto.model.data.Lotto

interface LottoBuilder {
    fun createLotto(): Lotto
}
