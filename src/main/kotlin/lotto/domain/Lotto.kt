package lotto.domain

data class Lotto(val lottoNumbers: Set<LottoNumber>) {
    companion object {
        fun generate(numberOfLotto: Int): List<Lotto> {
            return List(numberOfLotto) { Lotto(createSingleLotto()) }
        }

        private fun createSingleLotto(): Set<LottoNumber> {
            return (MINIMUM_NUMBER..MAXIMUM_NUMBER).shuffled()
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
