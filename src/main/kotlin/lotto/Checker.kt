package lotto

import lotto.util.toIntThrow

class Checker(LastNumberText: String) {

    private val numberList = LastNumberText.split(Lotto.LOTTO_NUMBER_DIVIDE_TEXT)

    init {
        require(numberList.size == Lotto.LOTTO_NUMBER_COUNT) { "로또번호는 6자리 숫자입니다." }
    }

    val lastNumbers: List<Int> = numberList.map { it.trim().toIntThrow() }

    fun match(lotto: List<Int>): Int = lotto.filter { it in lastNumbers }.size
}
