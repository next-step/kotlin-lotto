package lotto.model

import lotto.model.number.LottoNumbers

class RandomNumbersGenerator : NumbersGenerator {
    override fun getNumbers(candidateSize: Int, resultSize: Int): LottoNumbers {
        return LottoNumbers(List(candidateSize) { i -> i + 1 }.shuffled().subList(0, resultSize))
    }
}
