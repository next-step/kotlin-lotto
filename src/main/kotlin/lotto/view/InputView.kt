package lotto.view

class InputView(private val maxTryCount: Int = DEFAULT_MAX_TRY_COUNT) {

    fun readLineNumber(question: String?, count: Int = 0): Int {
        return try {
            val input: String = readLine(question, count)

            if (input.toIntOrNull() == null) {
                throw IllegalArgumentException("숫자를 입력해주세요.")
            }

            input.toInt()
        } catch (notNumberException: IllegalArgumentException) {
            println(notNumberException.message)
            this.readLineNumber(question, count + 1)
        }
    }

    fun readLineNumberList(question: String?, count: Int = 0): List<Int> {
        return try {
            val input: String = readLine(question, count)

            input.split(", ").map {
                it.toIntOrNull() ?: throw IllegalArgumentException("숫자를 입력해주세요.")
            }
        } catch (notNumberException: IllegalArgumentException) {
            println(notNumberException.message)
            this.readLineNumberList(question, count + 1)
        }
    }

    private fun readLine(question: String?, count: Int = 0): String {
        val inputResult: Result<String> = runCatching {
            if (count >= this.maxTryCount) {
                throw IllegalStateException("입력 횟수를 초과하였습니다.")
            }

            if (question != null) {
                if (count > 0) {
                    val leftCount: String = (maxTryCount - count).toString()
                    println("잘못된 입력입니다. $leftCount 번 더 입력할 수 있습니다.")
                }

                println(question)
            }

            return readlnOrNull() ?: throw IllegalArgumentException("입력값이 없습니다.")
        }.onFailure {
            if (count < this.maxTryCount) {
                return this.readLine(question, count + 1)
            }

            throw IllegalStateException("입력 횟수를 초과하였습니다.")
        }

        return inputResult.getOrThrow()
    }

    companion object {
        private const val DEFAULT_MAX_TRY_COUNT: Int = 3
    }
}
