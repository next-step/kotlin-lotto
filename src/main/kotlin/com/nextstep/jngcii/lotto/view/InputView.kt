package com.nextstep.jngcii.lotto.view

object InputView {
    tailrec fun getCount(read: () -> String?): Int {
        println("구입금액을 입력해 주세요.")

        InputValidator.validateInputCount(read())?.let { return it }

        return getCount { readLine() }
    }

    tailrec fun getNumbers(read: () -> String?): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")

        InputValidator.validateInputNumbers(read())?.let { return it }

        return getNumbers { readLine() }
    }
}
