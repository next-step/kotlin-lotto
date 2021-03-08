package view.console

import view.InputView

class ConsoleInput : InputView {
    override fun read() = readLine()!!
}
