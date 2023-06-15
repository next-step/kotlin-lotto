package lotto.view

class InputView {
    operator fun invoke(msg: String): String {
        println(msg)
        return readln()
    }
}
