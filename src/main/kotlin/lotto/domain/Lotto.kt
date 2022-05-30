package lotto.domain

class Lotto(lottoNumber: List<Int>) {
    private val _lottoNumber = lottoNumber
    val lottoNumber
        get() = _lottoNumber

    init {
        require(lottoNumber.size == LOTTO_NUMBER_SIZE) { LOTTO_NUMBER_SIZE_MESSAGE }
        require(lottoNumber.toSet().size == LOTTO_NUMBER_SIZE) { LOTTO_DUPLICATE_MESSAGE }
    }

    fun getCountWithWinningLottoNumber(winningLottoNumbers: List<Int>): Int {
        return winningLottoNumbers
            .filter { number -> _lottoNumber.contains(number) }.size
    }

    fun exchangeCountToMoney(count: Int): Int {
        return when (count) {
            LottoMatch.THREE.count -> LottoMatch.THREE.prize
            LottoMatch.FOUR.count -> LottoMatch.FOUR.prize
            LottoMatch.FIVE.count -> LottoMatch.FIVE.prize
            LottoMatch.SIX.count -> LottoMatch.SIX.prize
            else -> ELSE_COUNT_MONEY
        }
    }

    companion object {
        private const val LOTTO_START_NUMBER = 1
        private const val LOTTO_END_NUMBER = 45
        private const val LOTTO_SIZE = 6
        private const val ELSE_COUNT_MONEY = 0
        private const val LOTTO_NUMBER_SIZE = 6
        private const val LOTTO_NUMBER_SIZE_MESSAGE = "로또 번호를 생성시 6개의 숫자가 생성되어야 합니다."
        private const val LOTTO_DUPLICATE_MESSAGE = "로또 번호를 생성시 중복된 숫자가 존재합니다."
        fun random(): Lotto {
            val lottoNumber = (LOTTO_START_NUMBER..LOTTO_END_NUMBER).shuffled().take(LOTTO_SIZE).sorted()
            return Lotto(lottoNumber)
        }
    }
}
