package lotto.domain

data class LottoNumber(val number: Int) {
    init {
        require(number in 1..45) { INVALID_WINNER_NUMBERS_RANGE_MESSAGE }
    }

    companion object{
        const val INVALID_WINNER_NUMBERS_RANGE_MESSAGE: String = "로또 당첨 번호는 1부터 45 사이 여야 합니다"
    }
}

