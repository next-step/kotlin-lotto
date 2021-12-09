package lotto.domain

data class LottoNum(val num: Int) {
    init {
        require(num in NUM_RANGE) { INVALID_NUMBER_RANGE_EXCEPTION_MSG }
    }

    override fun toString(): String {
        return num.toString()
    }

    companion object {
        val NUM_RANGE = 1..45
        private const val INVALID_NUMBER_RANGE_EXCEPTION_MSG = "로또 번호는 1 ~ 45 사이의 숫자이어야 합니다."
    }
}
