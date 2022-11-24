package lotto.domain

class Lotto(val numbers: Set<LottoNumber> = createLottoNumbers()) {
    init {
        require(numbers.size == LOTTO_NUMBER_COUNT) { "로또 당첨 번호는 6개입니다." }
    }

    companion object {
        private val LOTTO_NUMBER_RANGE = 1..45
        const val LOTTO_NUMBER_COUNT = 6
        fun createLottoNumbers(): Set<LottoNumber> =
            (LOTTO_NUMBER_RANGE).shuffled().subList(0, LOTTO_NUMBER_COUNT)
                .sorted()
                .map { LottoNumber(it) }
                .toSet()
    }
}
