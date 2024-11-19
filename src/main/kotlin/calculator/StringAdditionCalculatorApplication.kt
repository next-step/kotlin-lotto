package calculator

class StringAdditionCalculatorApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val str = readln()
            val calculator = StringAdditionCalculator(str)
            println(calculator.add())
        }
    }
}
