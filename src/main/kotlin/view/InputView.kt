package view

class InputView {
    private val guideInputMsg = "값을 입력해주세요"
    fun input(): String? {
        println(guideInputMsg)
        return readln()
    }
}
