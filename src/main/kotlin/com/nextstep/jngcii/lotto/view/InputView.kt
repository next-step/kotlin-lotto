package com.nextstep.jngcii.lotto.view

import com.nextstep.jngcii.lotto.model.Calculator

object InputView {
    tailrec fun getCount(read: () -> String?): Int {
        println("구입금액을 입력해 주세요.")

        InputValidator.validateInt(read())
            ?.let { return Calculator.calculateLottoCount(it) }

        return getCount { readLine() }
    }

    tailrec fun getNumbers(read: () -> String?): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")

        InputValidator.validateInputNumbers(read())?.let { return it }

        return getNumbers { readLine() }
    }

    fun getNumber(read: () -> String?): Int {
        println("보너스 볼을 입력해 주세요.")

        while (true) {
            InputValidator.validateInputNumber(read())?.let { return it }
        }
    }
}
