package lotto.util

import lotto.domain.LottoNumbers

interface AutoNumbers {
    fun generateNumbers(): LottoNumbers
}
