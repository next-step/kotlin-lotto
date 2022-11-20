package calculator.interfaces.output

sealed interface OutputPlugin {
    fun output(result: String)
}
