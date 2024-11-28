package lotto.domain

class Lotto private constructor(val lottoNumbers: Set<LottoNumber>) {
    companion object {
        private const val NUMBER_OF_SELECT = 6

        fun createLotto(numbers: List<Int>): Lotto {
            val lottoNumbers =
                numbers
                    .take(NUMBER_OF_SELECT)
                    .sorted()
                    .map { LottoNumber.from(it) }
                    .toSet()

            return Lotto(lottoNumbers)
        }
    }
}
