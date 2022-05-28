package lotto.domain

data class LottoNumber(val number: Int) {
    init {
        require(number in MIN_NUMBER..MAX_NUMBER) { "$MIN_NUMBER ~ $MAX_NUMBER 범위의 숫자만 가능합니다." }
    }

    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
    }
}
