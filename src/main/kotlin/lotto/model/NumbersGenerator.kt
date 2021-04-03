package lotto.model

import lotto.model.number.LottoNumbers

interface NumbersGenerator {
    fun getNumbers(candidateSize: Int, resultSize: Int): LottoNumbers
}
