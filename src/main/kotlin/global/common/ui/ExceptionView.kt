package global.common.ui

import global.strategy.ui.OutputStrategy

class ExceptionView(private val outputStrategy: OutputStrategy) {
    fun output(message: String) = outputStrategy.output(message)
}
