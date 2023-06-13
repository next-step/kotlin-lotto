package io

object InputView {
    fun getInput(): String? {
        println("수식을 입력하세요.")
        return readlnOrNull()
    }
}
