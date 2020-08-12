package com.nextstep.stringcalculator

import com.nextstep.stringcalculator.domain.StringCalculator
import com.nextstep.stringcalculator.view.InputView
import com.nextstep.stringcalculator.view.OutputView

fun main() {
    val userInput = InputView.input()
    val calculator = StringCalculator.createCalculator(userInput)
    OutputView.showResult(calculator.calculate())
}
