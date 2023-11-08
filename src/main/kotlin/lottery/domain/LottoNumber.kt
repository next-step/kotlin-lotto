package lottery.domain

data class LottoNumber(val lottoNumber: Int) {

    init {
        require(lottoNumber in MIN_NUMBER..MAX_NUMBER) { INVALID_NUMBER_RANGE_MESSAGE }
    }

    override fun toString() = lottoNumber.toString()

    companion object {
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
        private const val INVALID_NUMBER_RANGE_MESSAGE = "로또 번호는 1에서 45 사이의 값이어야 합니다."
    }
}
