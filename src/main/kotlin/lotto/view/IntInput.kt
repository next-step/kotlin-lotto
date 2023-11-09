package lotto.view

class IntInput(text: String) {
    val input: Int

    init {
        require(text.toIntOrNull() != null) {
            "You need to enter integer"
        }
        input = text.toInt()
    }
}
