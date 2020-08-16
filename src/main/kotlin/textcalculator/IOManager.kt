package textcalculator

class IOManager {
    fun input(): String? {
        return readLine() ?: ""
    }

    fun output(message: String) {
        println(message)
    }
}
