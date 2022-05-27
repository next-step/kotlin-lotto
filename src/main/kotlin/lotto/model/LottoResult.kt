package lotto.model

import lotto.constants.Messages

/**
 * 로또 결과 값을 저장하는 데이터 클래스.
 * Created by Jaesungchi on 2022.05.25..
 */
data class LottoResult(val prize: Prize, val count: Int) {
    val prizeMessage: String? = when (prize) {
        Prize.FIRST_PLACE -> {
            Messages.CORRECT_SIX.format(count)
        }
        Prize.SECOND_PLACE -> {
            Messages.CORRECT_FIVE.format(count)
        }
        Prize.THIRD_PLACE -> {
            Messages.CORRECT_FOUR.format(count)
        }
        Prize.FOURTH_PLACE -> {
            Messages.CORRECT_THREE.format(count)
        }
        else -> null
    }
}
