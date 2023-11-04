package calculator.view

object InputView {

    fun input(): String? {
        print("계산할 식을 입력하세요 : ")
        return readlnOrNull()
    }
}
