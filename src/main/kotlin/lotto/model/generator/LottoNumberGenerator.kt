package lotto.model.generator

import lotto.model.lotto.Numbers

interface LottoNumberGenerator {
    fun generate(): Numbers
}
