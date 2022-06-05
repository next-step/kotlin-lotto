package lotto.domain

class Lotto(lottoNumber: List<Int>) {
    val lottoNumber = lottoNumber.toList()

    init {
        require(lottoNumber.size == LOTTO_NUMBER_SIZE) { LOTTO_NUMBER_SIZE_MESSAGE }
        require(lottoNumber.toSet().size == LOTTO_NUMBER_SIZE) { LOTTO_DUPLICATE_MESSAGE }
        require(lottoNumber.all { number -> number in LOTTO_START_NUMBER..LOTTO_END_NUMBER }) { LOTTO_RANGE_MESSAGE }
    }

    fun getCountWithWinningLottoNumber(winningLottoNumbers: List<Int>): Int {
        return winningLottoNumbers
            .filter { number -> lottoNumber.contains(number) }.size
    }

    companion object {
        private const val LOTTO_START_NUMBER = 1
        private const val LOTTO_END_NUMBER = 45
        private const val LOTTO_SIZE = 6
        private const val ELSE_COUNT_MONEY = 0
        private const val LOTTO_NUMBER_SIZE = 6
        private const val LOTTO_NUMBER_SIZE_MESSAGE = "로또 번호를 생성시 6개의 숫자가 생성되어야 합니다."
        private const val LOTTO_DUPLICATE_MESSAGE = "로또 번호를 생성시 중복된 숫자가 존재합니다."
        private const val LOTTO_RANGE_MESSAGE = "로또 번호는 1 ~ 45 사이의 숫자이어야 합니다."

        fun random(): Lotto {
            val lottoNumber = (LOTTO_START_NUMBER..LOTTO_END_NUMBER).shuffled().take(LOTTO_SIZE).sorted()
            return Lotto(lottoNumber)
        }
    }
}
