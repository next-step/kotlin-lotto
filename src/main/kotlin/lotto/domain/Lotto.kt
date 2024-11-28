package lotto.domain

import lotto.stretagy.NumberListGenerator

data class Lotto(val lottoNumbers: Set<LottoNumber>) {
    companion object {
        private const val NUMBER_OF_SELECT = 6

        fun generate(
            numberListGenerator: NumberListGenerator,
            numberOfLotto: Int,
        ): List<Lotto> {
            val lottoNumbers = numberListGenerator.generate()
            return List(numberOfLotto) { Lotto(createSingleLotto(lottoNumbers)) }
        }

        private fun createSingleLotto(numbers: List<Int>): Set<LottoNumber> {
            return numbers
                .take(NUMBER_OF_SELECT)
                .sorted()
                .map { LottoNumber.from(it) }
                .toSet()
        }
    }
}
