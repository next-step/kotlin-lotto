package lotto.view.result

import lotto.view.dto.LottosDto

object LottosView {
    fun print(dto: LottosDto) {
        val sb = StringBuilder()

        dto.lottos.forEach {
            sb.append("[${it.numbers.joinToString(", ")}]\n")
        }

        println(sb.toString())
    }
}
