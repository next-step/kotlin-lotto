package lotto.domain

class LottoLuckyDraw(
    luckyNumberString: String
) {

    init {
        val luckyNumbers = luckyNumberString.replace(" ", "").split(",")
        require(luckyNumbers.count() == INSERT_LIMIT_NUMBER_COUNT) { "당첨번호는 6개만 입력해주세요" }
        luckyNumbers.forEach {
            require(LUCKY_DRAW_MAX_NUM > it.toInt()) { "숫자는 45 이하만 입력 가능합니다." }
            require(LUCKY_DRAW_MIN_NUM <= it.toInt()) { "숫자는 1 이상만 입력 가능합니다." }
        }
    }

    val luckyNumber = luckyNumberString.replace(" ", "").split(",").map { it.toInt() }


    companion object {
        private const val LUCKY_DRAW_MIN_NUM = 1
        private const val LUCKY_DRAW_MAX_NUM = 45
        private const val INSERT_LIMIT_NUMBER_COUNT = 6
    }
}
