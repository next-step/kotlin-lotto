package com.nextstep.second.lotto

import com.nextstep.second.lotto.domain.Lotto
import com.nextstep.second.lotto.domain.LottoNumberVo.Companion.LOTTO_NUMBER_UNDER_BOUNDARY
import com.nextstep.second.lotto.domain.LottoNumberVo.Companion.LOTTO_NUMBER_UPPER_BOUNDARY

object NumberGenerator {
    fun generate(): List<Int> = (LOTTO_NUMBER_UNDER_BOUNDARY..LOTTO_NUMBER_UPPER_BOUNDARY)
        .shuffled()
        .take(Lotto.LOTTO_LENGTH)
}
