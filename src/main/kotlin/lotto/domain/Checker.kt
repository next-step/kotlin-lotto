package lotto.domain

import lotto.util.toIntThrow

class Checker(LastNumberText: String) {

    private val numberList = LastNumberText.split(Lotto.LOTTO_NUMBER_DIVIDE_TEXT)

    init {
        require(numberList.size == Lotto.LOTTO_NUMBER_COUNT) { "로또번호는 6자리 숫자입니다." }
    }

    private val lastNumbers: List<Int> = numberList
        .map { it.trim().toIntThrow() }
        .distinct()
        .takeIf { it.size == 6 }
        ?: throw RuntimeException("로또번호는 중복을 허용하지 않는 6자리 숫자입니다.")

    fun match(lotto: List<Int>): Int = lotto.filter { it in lastNumbers }.size
}
