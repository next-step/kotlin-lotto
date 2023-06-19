package lotto.model

class Lotto(val numbers: Set<LottoNumber>) {

    init {
        require(numbers.size == LOTTO_SIZE) {
            "로또 번호는 $LOTTO_SIZE 개 이어야 합니다."
        }
    }

    companion object {
        private const val LOTTO_SIZE = 6
        private const val DELIMITER = ","

        fun create() = Lotto(
            (LottoNumber.LOTTO_NUMBER_MIN..LottoNumber.LOTTO_NUMBER_MAX).shuffled().take(LOTTO_SIZE).sorted()
                .map { LottoNumber(it) }.toSet()
        )

        fun createWinning(numbers: String) = Lotto(numbers.split(DELIMITER).map { LottoNumber(it.toInt()) }.toSet())
    }
}
