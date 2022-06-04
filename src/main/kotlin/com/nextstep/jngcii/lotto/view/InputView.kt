package com.nextstep.jngcii.lotto.view

import com.nextstep.jngcii.lotto.model.Calculator

object InputView {
    tailrec fun getCount(): Int {
        println("구입금액을 입력해 주세요.")

        InputValidator.validateInt(readLine())
            ?.let { return Calculator.calculateLottoCount(it) }

        return getCount()
    }

    tailrec fun getNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")

        InputValidator.validateInputNumbers(readLine())
            ?.let { return it }

        return getNumbers()
    }

    fun getNumber(): Int {
        println("보너스 볼을 입력해 주세요.")

        InputValidator.validateInputNumber(readLine())
            ?.let { return it }

        return getNumber()
    }
}
