package lotto.model

class Lotto(val numbers: Set<LottoNumber>) {

    init {
        require(numbers.size == LOTTO_SIZE) {
            "로또 번호는 $LOTTO_SIZE 개 이어야 합니다."
        }
    }

    fun matchingCount(lotto: Lotto) = numbers.count {
        it in lotto.numbers
    }

    companion object {
        private const val LOTTO_SIZE = 6

        fun create() = Lotto(
            (LottoNumber.LOTTO_NUMBER_MIN..LottoNumber.LOTTO_NUMBER_MAX).shuffled().take(LOTTO_SIZE).sorted()
                .map { LottoNumber(it) }.toSet()
        )

        fun createWinning(numbers: List<Int>) = Lotto(numbers.map { LottoNumber(it) }.toSet())
    }
}
