package textcalculator

fun main() {
    val ioManager = object : IOManager {
        override fun input(): String? {
            val temp = readLine() ?: ""
            return temp
        }

        override fun output(message: String) {
            println(message)
        }
    }

    TextCalculator(ioManager, Parser(), Calculator())
        .execute()
}
