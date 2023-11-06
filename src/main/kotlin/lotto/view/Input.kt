package lotto.view

import java.lang.IllegalArgumentException

object Input {

    fun getLine() = readlnOrNull() ?: throw IllegalArgumentException("입력하여 주세요.")
}
