package lotto.view

import lotto.domain.LottoNumbers
import lotto.domain.WinningNumbers
import java.io.InputStreamReader
import java.io.StringReader
import java.util.Scanner

interface UserInput<T> {
    fun answer(): T

    companion object {
        fun winningNumbers(): WinningNumbers {
            val winningNumber = IntList("\n지난 주 당첨 번호를 입력해 주세요.").answer()
                .let {
                    LottoNumbers(it)
                }
            val bonusNumber = Int("보너스 볼을 입력해 주세요.").answer()
            return WinningNumbers(winningNumber, bonusNumber)
        }
    }

    class Int(
        question: String,
        readable: Readable = InputStreamReader(System.`in`)
    ) : UserInput<kotlin.Int> {
        private val scanner: Scanner = Scanner(readable)

        init {
            println(question)
        }

        constructor(question: String, answer: String) : this(question, StringReader(answer))

        override fun answer(): kotlin.Int {
            return scanner.nextInt()
        }
    }

    class IntList(
        question: String,
        readable: Readable = InputStreamReader(System.`in`)
    ) : UserInput<List<kotlin.Int>> {
        private val scanner: Scanner = Scanner(readable)

        init {
            println(question)
        }

        constructor(question: String, answer: String) : this(question, StringReader(answer))

        override fun answer(): List<kotlin.Int> {

            return scanner.nextLine()
                .split(",")
                .map { it.toInt() }
        }
    }

    class IntListGroup(
        private val groupSize: kotlin.Int,
        private val intListInput: IntList
    ) : UserInput<List<List<kotlin.Int>>> {

        constructor(
            question: String,
            groupSize: kotlin.Int,
            readable: Readable = InputStreamReader(System.`in`)
        ) : this(groupSize, IntList(question, readable))

        constructor(
            question: String,
            groupSize: kotlin.Int,
            answer: String
        ) : this(question, groupSize, StringReader(answer))

        override fun answer(): List<List<kotlin.Int>> {
            return (0 until groupSize).map {
                intListInput.answer()
            }
        }
    }
}
