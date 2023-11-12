package lotto.view
class InputView {
    fun inputPrice(inputType: InputType): Int {
        println(inputType.question)
        return readln().toInt()
    }

    fun inputNumbers(inputType: InputType): List<Int> {
        println(inputType.question)
        return readln().split(", ").map { it.toInt() }
    }
}
