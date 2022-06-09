package lotto.view

import lotto.domain.model.UserInputRequest

object InputView {
    fun println(message: String) {
        println(message)
    }

    fun <T> receiveUserInput(userInputRequest: UserInputRequest<T>): T {
        println(userInputRequest.message)
        return userInputRequest.inputConverter.convert(readln())
    }
}
