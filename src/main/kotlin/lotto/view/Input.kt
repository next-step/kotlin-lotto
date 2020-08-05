package lotto.view

import lotto.LOTTO_NUMBERS_COUNT
import lotto.domain.ManualLotto
import kotlin.system.exitProcess

fun inputMoney(): Int {
    println("구입금액을 입력해 주세요.")
    return readLine()?.toIntOrNull() ?: inputMoneyError()
}

fun inputMoneyError(): Int {
    println(
        """
        구입금액을 입력해 주세요. 
        숫자만 입력해주세요
        Ex) 15000,20000,25000
        """.trimIndent()
    )
    return readLine()?.toIntOrNull() ?: exitProcess(0)
}

fun inputManualCount(): Int {
    println("수동으로 구매할 로또 수를 입력해 주세요.")
    return readLine()?.toIntOrNull() ?: inputManualCountError()
}

fun inputManualCountError(): Int {
    println(
        """
        수동으로 구매할 로또 수를 입력해 주세요.
        숫자만 입력해주세요
        Ex) 1 / 2 / 3
        """.trimIndent()
    )
    return readLine()?.toIntOrNull() ?: exitProcess(0)
}

fun inputManualNumbers(count: Int): ManualLotto {
    println("수동으로 구매할 번호를 입력해 주세요.")
    val list = ManualLotto()
    var errorCount = 0
    do {
        if (errorCount > 1) exitProcess(0)

        val result = readLine() ?: ""
        if (resultInvalid(result)) {
            list.add(result.split(",").map { it.toInt() })
        } else {
            println("Ex) 1,2,3,4,5,6 처럼 입력해주세요")
            errorCount++
        }
    } while (list.getAll().size < count)
    return list
}

fun inputResult(): List<Int> {
    println("지난 주 당첨 번호를 입력해 주세요.")
    val result = readLine() ?: ""
    return if (resultInvalid(result)) {
        result.split(",").map { it.toInt() }
    } else {
        inputResultError()
    }
}

fun inputResultError(): List<Int> {
    println(
        """
        지난 주 당첨 번호를 입력해 주세요.
        Ex) 1,2,3,4,5,6 / 2,5,7,9,10
        """.trimIndent()
    )
    val result = readLine() ?: ""
    return if (resultInvalid(result)) {
        result.split(",").map { it.toInt() }
    } else {
        exitProcess(0)
    }
}

fun inputBonusNumber(numbers: List<Int>): Int {
    println("보너스 볼을 입력해 주세요.")
    val bonusNumber = readLine()?.toIntOrNull() ?: inputBonusNumberError()
    return if (numbers.contains(bonusNumber)) {
        inputBonusNumberError()
    } else {
        return bonusNumber
    }
}

fun inputBonusNumberError(): Int {
    println(
        """
        보너스 볼을 입력해 주세요.
        한 자리의 숫자만 입력해주세요
        그 숫자는 당첨번호와 중복될 수 없습니다.
        """.trimIndent()
    )
    return readLine()?.toIntOrNull() ?: exitProcess(0)
}

fun resultInvalid(readLine: String): Boolean {
    return !(readLine.isEmpty() || !readLine.contains(",") || readLine.split(",").size != LOTTO_NUMBERS_COUNT)
}
