package caculator.ui

class InputView(private val inputStrategy: InputStrategy) {
    val value = Input(tryEnterInput())

    private fun tryEnterInput(): String {
        return inputStrategy.enter()
            ?: ""
    }
}
