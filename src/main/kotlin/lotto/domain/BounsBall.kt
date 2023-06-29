package lotto.domain

class BounsBall(val bounsNumber: Int) {
    init {
        validateBounsNumber(bounsNumber)
    }

    fun validateBounsNumber(bounsNumber: Int) {
        require(bounsNumber in LotteryPaper.LOTTO_NUMBER_BOUNDS) { "로또 범위의 숫자만 가능합니다. 입력값을 다시 확인하세요." }
    }
}
