package lotto

import lotto.LottoRule.LOTTO_NUMBER_COUNT

class LottoTickets(val lottery: List<Lotto> = emptyList())
class WinningLotto(numbers: List<Int>) : Lotto(numbers)
open class Lotto(val numbers: List<Int>) {
    init {

        numbers.forEach {
            require(it > 0) { NOT_POSITIVE_NUMBER_MESSAGE }
        }

        require(numbers.size == LOTTO_NUMBER_COUNT) {
            NOT_MATCH_NUMBER_COUNT
        }

        require(numbers.any { it > LottoRule.MIN_NUMBER } && numbers.any { it <= LottoRule.MAX_NUMBER }) {
            NOT_RANGE_NUMBER_MESSAGE
        }

    }

    companion object {
        private const val NOT_POSITIVE_NUMBER_MESSAGE = "로또 번호는 0 또는 음수일 수 없습니다."
        private const val NOT_MATCH_NUMBER_COUNT = "로또 번호는 $LOTTO_NUMBER_COUNT 개의 숫자로 구성되어야 합니다"
        private const val NOT_RANGE_NUMBER_MESSAGE = "로또 번호는 ${LottoRule.MIN_NUMBER} ~ ${LottoRule.MAX_NUMBER} 사이의 숫자로 구성되어야 합니다."
    }
}
