package com.nextstep.jngcii.lotto.view

import com.nextstep.jngcii.lotto.model.Calculator
import com.nextstep.jngcii.lotto.service.InputValidator

object InputView {
    tailrec fun getCount(): Int {
        println("구입금액을 입력해 주세요.")

        return runCatching {
            Calculator.calculateLottoCount(readLine().toPositiveInt)
        }.getOrElse {
            println("${it.message} 다시 입력해주세요.")
            return getCount()
        }
    }

    tailrec fun getPassiveCount(total: Int): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")

        return runCatching {
            val passiveCount = readLine().toPositiveInt

            require(passiveCount <= total) { "전체 로또보다 적어야 합니다." }

            passiveCount
        }.getOrElse {
            println("${it.message} 다시 입력해주세요.")
            return getPassiveCount(total)
        }
    }

    tailrec fun getNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")

        return runCatching {
            readLine().splitToPositiveIntList
        }.getOrElse {
            println("${it.message} 다시 입력해주세요.")
            return getNumbers()
        }
    }

    tailrec fun getNumber(): Int {
        println("보너스 볼을 입력해 주세요.")

        return runCatching {
            readLine().toPositiveInt
        }.getOrElse {
            println("${it.message} 다시 입력해주세요.")
            return getNumber()
        }
    }

    private val String?.splitToPositiveIntList
        get(): List<Int> {
            val notNullValue = InputValidator.validateNotNull(this)
            return notNullValue.split(",").map {
                val intValue = InputValidator.validateInt(it)
                InputValidator.validatePositive(intValue)
            }
        }

    private val String?.toPositiveInt
        get(): Int {
            val notNullValue = InputValidator.validateNotNull(this)
            val intValue = InputValidator.validateInt(notNullValue)
            return InputValidator.validatePositive(intValue)
        }
}
