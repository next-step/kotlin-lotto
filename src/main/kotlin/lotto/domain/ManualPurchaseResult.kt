package lotto.domain

import lotto.utils.Validation

class ManualPurchaseResult(number: String) {

    var numberOfGames: Int = 0
        private set

    init {
        require(Validation.isNotBlank(number)) { "공백 값이 들어왔습니다." }
        require(Validation.isNumeric(number)) { "숫자가 아닌 문자가 들어왔습니다." }
        val numberToInt = number.toInt()
        require(numberToInt > -1) { "최소 구매 횟수보다 적습니다." }
        numberOfGames = numberToInt
    }
}
