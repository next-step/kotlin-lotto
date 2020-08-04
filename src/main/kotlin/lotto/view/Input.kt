package lotto.view

import java.lang.IllegalArgumentException

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
    return readLine()?.toIntOrNull() ?: throw IllegalArgumentException("잘못된 입력")
}

fun inputResult(): List<Int> {
    println("지난 주 당첨 번호를 입력해 주세요.")
    val result = readLine() ?: ""
    return if (resultInvalid(result)) {
        inputResultError()
    } else {
        result.split(",").map { it.toInt() }
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
        throw IllegalArgumentException("잘못된 입력")
    } else {
        result.split(",").map { it.toInt() }
    }
}

fun resultInvalid(readLine: String): Boolean {
    return (readLine.isEmpty() || !readLine.contains(",") || readLine.split(",").size != 6)
}
