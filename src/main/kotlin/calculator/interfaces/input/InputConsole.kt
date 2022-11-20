package calculator.interfaces.input

object InputConsole : InputPlugin {

    override fun input(): String {
        println("덧셈이 필요한 문자열을 입력하세요.")
        return readln()
    }
}
