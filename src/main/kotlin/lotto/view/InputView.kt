package lotto.view

import lotto.domain.model.UserInputRequest
import lotto.domain.model.UserInputResult
import lotto.domain.model.result

object InputView {
    fun printGuidanceMessage(message: String) {
        println(message)
    }

    fun <T> receiveUserInput(userInputRequest: UserInputRequest<T>): T {
        println(userInputRequest.message)
        return receiveUserInputWithoutMessage(userInputRequest)
    }

    fun <T> receiveUserInputWithoutMessage(userInputRequest: UserInputRequest<T>): T {
        var userInputResult: UserInputResult<T> = userInputRequest.inputConverter.convert(readlnOrNull())
        while (userInputResult is UserInputResult.Failed) {
            println(userInputRequest.retryMessage)
            userInputResult = userInputRequest.inputConverter.convert(readlnOrNull())
        }

        return userInputResult.result
    }
}
