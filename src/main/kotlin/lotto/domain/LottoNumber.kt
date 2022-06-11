package lotto.domain

data class LottoNumber(val number: Int) {
    init {
        require(number >= LottoRule.MIN_NUMBER && number <= LottoRule.MAX_NUMBER) {
            NOT_RANGE_NUMBER_MESSAGE
        }
    }

    companion object {
        private const val NOT_RANGE_NUMBER_MESSAGE = "로또 번호는 ${LottoRule.MIN_NUMBER} ~ ${LottoRule.MAX_NUMBER} 사이의 숫자로 구성되어야 합니다."
    }
}
