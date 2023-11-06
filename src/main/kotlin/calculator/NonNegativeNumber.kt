package calculator

class NonNegativeNumber(text: String) {

    var value: Int
        private set

    init {
        require(!text.startsWith("-")) {
            throw RuntimeException()
        }
        value = text.toInt()
    }
}
