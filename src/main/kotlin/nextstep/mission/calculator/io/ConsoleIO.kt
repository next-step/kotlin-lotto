package nextstep.mission.calculator.io

object ConsoleInput {
    fun input(): String? = readLine()
}

object ConsoleOutput {
    fun output(result: Int) {
        println(result)
    }
}
