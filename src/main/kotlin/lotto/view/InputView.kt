package lotto.view

import lotto.domain.model.UserInputRequest

object InputView {
    fun printGuidanceMessage(message: String) {
        println(message)
    }

    fun <T> receiveUserInput(userInputRequest: UserInputRequest<T>): T {
        println(userInputRequest.message)
        return userInputRequest.inputConverter.convert(readln())
    }

    fun <T> receiveUserInputWithoutMessage(userInputRequest: UserInputRequest<T>): T {
        return userInputRequest.inputConverter.convert(readln())
    }
}
