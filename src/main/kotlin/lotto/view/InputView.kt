package lotto.view

import lotto.domain.Money

object InputView {
    private const val REGEX = ","

    fun inputMoney(): Money {
        println("구입 금액을 입력해주세요.")
        val input: Int = readln().toInt()
        return Money(input)
    }

    fun inputWinNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val input: String = readln().replace(" ", "")
        val inputStrings = input.split(REGEX.toRegex())
            .dropLastWhile { it.isEmpty() }
            .toTypedArray()
        val lottoNumbers: MutableList<Int> = ArrayList()
        for (i in inputStrings) {
            lottoNumbers.add(i.toInt())
        }
        return lottoNumbers
    }

    fun inputBonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        return readln().toInt()
    }
}
