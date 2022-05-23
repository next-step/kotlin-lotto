package calculator

class StringAddCalculator {
    fun add(params: Params): Int {
        return params.fold(0) { acc, i -> acc + i }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("더하고자 하는 값을 입력하세요. 예) “1,2:3“ 혹은 “//;\\n1;2;3”")
            val params = Params(readLine()?.replace("\\n", "\n"))
            val res = StringAddCalculator().add(params)
            println("결과는 $res 입니다.")
        }
    }
}
