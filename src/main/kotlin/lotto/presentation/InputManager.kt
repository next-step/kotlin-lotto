package lotto.presentation

class InputManager {
    fun inputPay(): Int {
        println(INPUT_NAME_OF_CARS_MESSAGE)
        return readln().toInt()
    }

    companion object {
        const val INPUT_NAME_OF_CARS_MESSAGE = "구입금액을 입력해 주세요."
    }
}