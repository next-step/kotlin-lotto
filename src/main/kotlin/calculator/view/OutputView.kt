package calculator.view

import calculator.Const

class OutputView {
    fun initMsg() {
        println(Const.OutputMsg.APPLICATION_START_MSG)
    }

    fun result(result: Double) {
        val resultToIntoOrDouble =
            if (exactInt(result)) {
                result.toInt()
            } else {
                result
            }
        println(resultToIntoOrDouble)
    }

    fun exactInt(result: Double) = result % 1 == 0.0
}
