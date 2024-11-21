package lotto

object ResultView {
    fun print(result: String) {
        println(result)
    }

    fun print(result: List<String>) {
        result.forEach {
            println(it)
        }
    }
}
