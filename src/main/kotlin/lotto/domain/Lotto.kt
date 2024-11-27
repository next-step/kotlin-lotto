package lotto.domain

class Lotto {
    companion object {
        fun generate(): Set<LottoNumber> {
            return (MINIMUM_NUMBER..MAXIMUM_NUMBER)
                .shuffled()
                .take(NUMBER_OF_SELECT)
                .sorted()
                .map { LottoNumber.from(it) }
                .toSet()
        }

        private const val MINIMUM_NUMBER = 1
        private const val MAXIMUM_NUMBER = 45
        private const val NUMBER_OF_SELECT = 6
    }
}
