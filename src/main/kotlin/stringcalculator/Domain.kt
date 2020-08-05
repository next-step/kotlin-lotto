package stringcalculator

import java.lang.IllegalArgumentException

interface Result {
    fun cal(x: Int, y: Int): Int
}

enum class Operation(val symbol: String) : Result {

    SUM("+") {
        override fun cal(x: Int, y: Int): Int {
            return x + y
        }
    },
    MINUS("-") {
        override fun cal(x: Int, y: Int): Int {
            return x - y
        }
    },

    MULTI("*") {
        override fun cal(x: Int, y: Int): Int {
            return x * y
        }
    },

    DIV("/") {
        override fun cal(x: Int, y: Int): Int {
            if (y == 0) throw IllegalArgumentException("0으로 나눌 수가 없습니다.")
            return x / y
        }
    };

    companion object {
        fun run(symbol: String): Operation {
            return enumValues<Operation>().first {
                it.symbol == symbol
            }
        }
    }
}
