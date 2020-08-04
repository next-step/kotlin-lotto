package lotto.view

import lotto.domain.Numbers

object InputView {

    val NUMERIC_REGEX = Regex("[0-9]*")

    fun purchasePrice(): Int {

        println("구입금액을 입력해 주세요.")
        val price = validate(readLine())

        return price
    }

    fun lastWinningNumbers(): Numbers {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val text = readLine()
        var winningNumbers = validateWinningNumber(text)

        while (winningNumbers == null) {
            println("다시 입력해주세요")
            winningNumbers = validateWinningNumber(readLine())
        }

        return winningNumbers.map { it.toInt() }.toSet()
    }

    fun validateWinningNumber(numbers: String?): Set<String>? {
        if (numbers.isNullOrBlank()) {
            println("잘못된 당첨 번호 입니다.")
            return null
        }

        val numbers = splitNumbers(numbers)
        numbers.map {
            if (!NUMERIC_REGEX.matches(it)) {
                println("잘못된 당첨 번호 입니다.")
                return null
            }
        }

        if (numbers.size != 6) {
            println("잘못된 당첨 번호 입니다.")
            return null
        }

        return numbers
    }

    fun validate(price: String?): Int {
        if (price.isNullOrBlank()) {
            println("잘못된 구입 가격을 입력하셨습니다.")
            return 0
        }
        if (NUMERIC_REGEX.matches(price)) {
            return price.toInt()
        }

        println("잘못된 구입 가격을 입력하셨습니다.")
        return 0
    }

    fun splitNumbers(numbers: String) = numbers
        .split(",")
        .filter { it.isNotBlank() }
        .map { it.trim() }
        .toSet()
}
