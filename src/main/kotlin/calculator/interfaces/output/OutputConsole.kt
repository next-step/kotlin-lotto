package calculator.interfaces.output

object OutputConsole : OutputPlugin {

    override fun output(result: String) {
        println(result)
    }
}
