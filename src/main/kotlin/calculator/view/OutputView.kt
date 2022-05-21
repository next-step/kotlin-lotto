package calculator.view

import calculator.Const

class OutputView {
    fun initMsg() {
        println(Const.OutputMsg.APPLICATION_START_MSG)
    }

    fun result(result: Double) {
        val resultToIntoOrDouble =
            if (result % 1 == 0.0) {
                result.toInt()
            } else {
                result
            }
        println(resultToIntoOrDouble)
    }
}
