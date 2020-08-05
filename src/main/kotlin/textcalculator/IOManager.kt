package textcalculator

class IOManager {
    fun input(): String? {
        val temp = readLine() ?: ""
        return temp
    }

    fun output(message: String) {
        println(message)
    }
}
